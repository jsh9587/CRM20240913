package company.demo_last_last202409121553.organization.service;

import company.demo_last_last202409121553.organization.dto.request.edit.OrganizationEditRequest;
import company.demo_last_last202409121553.organization.dto.request.store.OrganizationStoreRequest;
import company.demo_last_last202409121553.organization.dto.response.findAll.OrganizationFindAllResponse;
import company.demo_last_last202409121553.organization.dto.response.findAll.FindAllUserEntityDto;
import company.demo_last_last202409121553.organization.dto.response.findById.FindByIdParentEntityDto;
import company.demo_last_last202409121553.organization.dto.response.findById.OrganizationFindByIdResponse;
import company.demo_last_last202409121553.organization.dto.response.findById.FindByIdUserEntityDto;
import company.demo_last_last202409121553.organization.dto.response.findByParentIdAndDepth.OrganizationFindByParentIdAndDepthResponse;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import company.demo_last_last202409121553.organization.repository.OrganizationRepository;
import company.demo_last_last202409121553.user.entity.UserEntity;
import company.demo_last_last202409121553.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    public OrganizationService(OrganizationRepository organizationRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
    }

    public List<OrganizationFindAllResponse> findAll() {
        List<OrganizationEntity> organizationEntities = organizationRepository.findAll();
        return organizationEntities.stream()
                .map(org -> new OrganizationFindAllResponse(
                        org.getId(),
                        org.getName(),
                        org.getDepth(),
                        Optional.ofNullable(org.getParentId()).orElse(0), // Default to 0 if null
                        org.getStatus(),
                        org.getSort(),
                        org.getUsers().stream()
                                .map(user -> new FindAllUserEntityDto(
                                        user.getId(),
                                        user.getName(),
                                        user.getEmail(),
                                        user.getPassword(),
                                        user.getRoles().toString()
                                ))
                                .collect(Collectors.toList()),
                        new ArrayList<>()
                ))
                .collect(Collectors.toList());
    }

    public List<OrganizationFindByParentIdAndDepthResponse> findByParentIdAndDepth(int parentId, int depth) {
        List<OrganizationEntity> organizationEntities = organizationRepository.findByParentIdAndDepth(parentId, depth);
        return organizationEntities.stream()
                .map(org -> new OrganizationFindByParentIdAndDepthResponse(
                        org.getId(),
                        org.getDepth(),
                        org.getParentId(),
                        org.getStatus(),
                        org.getSort(),
                        org.getName()
                ))
                .collect(Collectors.toList());
    }

    public OrganizationFindByIdResponse findById(int id) {
        OrganizationEntity organizationEntity = organizationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Organization not found with id: " + id));

        Integer parentId = organizationEntity.getParentId(); // Parent ID could be null

        return OrganizationFindByIdResponse.builder()
                .id(organizationEntity.getId())
                .depth(organizationEntity.getDepth())
                .parent_id(parentId) // Allow null for parent_id
                .status(organizationEntity.getStatus())
                .sort(organizationEntity.getSort())
                .name(organizationEntity.getName())
                .users(organizationEntity.getUsers().stream()
                        .map(user -> FindByIdUserEntityDto.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .email(user.getEmail())
                                .roles(user.getRoles().toString())
                                .build())
                        .collect(Collectors.toList()))
                .parent(organizationEntity.getParent() != null ? FindByIdParentEntityDto.builder()
                        .id(organizationEntity.getParent().getId())
                        .name(organizationEntity.getParent().getName())
                        .build() : null) // Handle null parent
                .build();
    }

    public List<OrganizationFindAllResponse> getOrganizationHierarchy() {
        List<OrganizationFindAllResponse> allOrganizations = findAll();
        return buildHierarchy(allOrganizations, 0); // Assuming 0 is the root parent_id
    }

    private List<OrganizationFindAllResponse> buildHierarchy(List<OrganizationFindAllResponse> allOrganizations, int parentId) {
        List<OrganizationFindAllResponse> hierarchy = new ArrayList<>();
        for (OrganizationFindAllResponse org : allOrganizations) {
            if (Objects.equals(org.getParent_id(), parentId)) {
                org.setChildren(buildHierarchy(allOrganizations, org.getId()));
                hierarchy.add(org);
            }
        }
        return hierarchy;
    }

    public ArrayList<OrganizationFindByIdResponse> getUserOrganizations(int id) {
        ArrayList<OrganizationFindByIdResponse> organizationHierarchy = new ArrayList<>();
        // Fetch the initial organization
        OrganizationFindByIdResponse org = findById(id);
        organizationHierarchy.add(org);

        // Recursively fetch parent organizations
        int depth = 1;
        while (org.getParent_id() != null && org.getParent_id() != 0 && depth < 4) {
            org = findById(org.getParent_id());
            organizationHierarchy.add(org);
            depth++;
        }

        Collections.reverse(organizationHierarchy);
        return organizationHierarchy;
    }

    public boolean store(OrganizationStoreRequest request){
        try{
            OrganizationEntity organization = new OrganizationEntity.Builder()
                    .name(request.getName())
                    .depth(request.getDepth())
                    .parentId(request.getParent_id())
                    .sort(request.getSort())
                    .status(request.getStatus()).build();

            OrganizationEntity savedOrganization =  organizationRepository.save(organization);
            return savedOrganization != null;
        } catch ( Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    public boolean edit(OrganizationEditRequest request) {
        try {
            OrganizationEntity organization = organizationRepository.findById(request.getId())
                    .orElseThrow(() -> new IllegalArgumentException("수정하려는 조직을 찾을 수 없습니다."));

            // 상태가 1인 경우
            if (request.getStatus() == 1) {
                List<UserEntity> users = userRepository.findByOrganizationId(organization.getId());
                if (!users.isEmpty()) {
                    throw new IllegalArgumentException("상태를 미사용으로 수정할 수 없습니다. 해당 조직에 사용자가 존재합니다.");
                }
                if (hasChildrenWithUsers(organization)) {
                    throw new IllegalArgumentException("상태를 미사용으로 수정할 수 없습니다. 자식 조직에 사용자가 존재합니다.");
                }
            }

            // 조직 업데이트
            OrganizationEntity organizationUpdated = new OrganizationEntity.Builder()
                    .id(organization.getId())
                    .depth(request.getDepth())
                    .name(request.getName())
                    .sort(request.getSort())
                    .status(request.getStatus())
                    .parentId(request.getParent_id())
                    .build();

            organizationRepository.save(organizationUpdated);

            return true;
        } catch (IllegalArgumentException e) {
            throw e; // Rethrow to be caught by the controller
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("예상치 못한 오류가 발생했습니다."); // Rethrow as a runtime exception
        }
    }

    private boolean hasChildrenWithUsers(OrganizationEntity organization) {
        // 자식 조직을 조회합니다.
        List<OrganizationEntity> children = organizationRepository.findByParentId(organization.getId());
        for (OrganizationEntity child : children) {
            // 자식 조직에 속한 사용자가 있는지 확인합니다.
            List<UserEntity> users = userRepository.findByOrganizationId(child.getId());
            if (!users.isEmpty()) {
                return true; // 자식 조직에 사용자가 있으면 true를 반환합니다.
            }
            // 자식 조직이 있을 경우 재귀적으로 검사합니다.
            if (hasChildrenWithUsers(child)) {
                return true;
            }
        }
        return false;
    }
}
