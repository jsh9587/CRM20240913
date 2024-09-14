package company.demo_last_last202409121553.organization.service;

import company.demo_last_last202409121553.organization.dto.response.findAll.FindAllResponse;
import company.demo_last_last202409121553.organization.dto.response.findAll.FindAllUserEntityDto;
import company.demo_last_last202409121553.organization.dto.response.findById.FindByIdResponse;
import company.demo_last_last202409121553.organization.dto.response.findById.FindByIdUserEntityDto;
import company.demo_last_last202409121553.organization.dto.response.findByParentIdAndDepth.FindByParentIdAndDepthResponse;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import company.demo_last_last202409121553.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<FindAllResponse> findAll() {
        List<OrganizationEntity> organizationEntities = organizationRepository.findAll();
        return organizationEntities.stream()
                .map(org -> new FindAllResponse(
                        org.getId(),
                        org.getName(),
                        org.getDepth(),
                        org.getParentId(),
                        org.getStatus(),
                        org.getSort(),
                        org.getUsers().stream()
                                .map(user -> new FindAllUserEntityDto(
                                        user.getId(),
                                        user.getName(),
                                        user.getEmail(),
                                        user.getPassword(),
                                        user.getRoles()
                                ))
                                .collect(Collectors.toList()),
                        new ArrayList<>()
                ))
                .collect(Collectors.toList());
    }

    public List<FindByParentIdAndDepthResponse> findByParentIdAndDepth(int parentId, int depth) {
        List<OrganizationEntity> organizationEntities =  organizationRepository.findByParentIdAndDepth(parentId, depth);
        return organizationEntities.stream()
                .map( org -> new FindByParentIdAndDepthResponse(
                        org.getId(),
                        org.getDepth(),
                        org.getParentId(),
                        org.getStatus(),
                        org.getSort(),
                        org.getName()
                )).collect(Collectors.toList());
    }

    public FindByIdResponse findById(int id) {
        OrganizationEntity organizationEntity = organizationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Organization not found with id: " + id));
        return new FindByIdResponse(
                organizationEntity.getId(),
                organizationEntity.getDepth(),
                organizationEntity.getParentId(),
                organizationEntity.getStatus(),
                organizationEntity.getSort(),
                organizationEntity.getName(),
                organizationEntity.getUsers().stream()
                        .map(user -> new FindByIdUserEntityDto(
                                user.getId(),
                                user.getName(),
                                user.getEmail(),
                                user.getRoles()
                        ))
                        .collect(Collectors.toList())
        );
    }

    public List<FindAllResponse> getOrganizationHierarchy() {
        List<FindAllResponse> allOrganizations = findAll();
        return buildHierarchy(allOrganizations, 0); // Assuming 0 is the root parent_id
    }

    private List<FindAllResponse> buildHierarchy(List<FindAllResponse> allOrganizations, int parentId) {
        List<FindAllResponse> hierarchy = new ArrayList<>();
        for (FindAllResponse org : allOrganizations) {
            if (org.getParent_id() == parentId) {
                org.setChildren(buildHierarchy(allOrganizations, org.getId()));
                hierarchy.add(org);
            }
        }
        return hierarchy;
    }

    public ArrayList<FindByIdResponse> getUserOrganizations(int id) {
        ArrayList<FindByIdResponse> organizationHierarchy = new ArrayList<>();
        // Fetch the initial organization (e.g., 1st level)
        FindByIdResponse org = findById(id);
        organizationHierarchy.add(org);
        // Recursively fetch parent organizations up to 4 levels
        int depth = 1;
//        System.out.println("org : "+org);
//        System.out.println("parent_id : "+org.getParent_id());
        while (org.getParent_id() != 0 && depth < 4) {
            org = findById(org.getParent_id());
            organizationHierarchy.add(org);
            depth++;
        }
        Collections.reverse(organizationHierarchy);
        return organizationHierarchy;
    }
}
