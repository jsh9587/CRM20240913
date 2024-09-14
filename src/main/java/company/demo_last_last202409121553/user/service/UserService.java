package company.demo_last_last202409121553.user.service;

import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.level.repository.LevelRepository;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import company.demo_last_last202409121553.organization.repository.OrganizationRepository;
import company.demo_last_last202409121553.user.dto.request.store.StoreRequest;
import company.demo_last_last202409121553.user.dto.response.findById.FindByIdResponse;
import company.demo_last_last202409121553.user.dto.response.findById.LevelEntityDto;
import company.demo_last_last202409121553.user.dto.response.findById.OrganizationEntityDto;
import company.demo_last_last202409121553.user.dto.response.findById.StatusEntityDto;
import company.demo_last_last202409121553.user.entity.StatusEntity;
import company.demo_last_last202409121553.user.entity.UserEntity;
import company.demo_last_last202409121553.user.repository.StatusRepository;
import company.demo_last_last202409121553.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final OrganizationRepository organizationRepository;
    private final LevelRepository levelRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, StatusRepository statusRepository, OrganizationRepository organizationRepository, LevelRepository levelRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.organizationRepository = organizationRepository;
        this.levelRepository = levelRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public FindByIdResponse findById(int id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        return new FindByIdResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getRoles(),
                new StatusEntityDto(
                        userEntity.getStatus().getId(),
                        userEntity.getStatus().getName(),
                        userEntity.getStatus().getSort()
                ),
                new LevelEntityDto(
                        userEntity.getLevel().getId(),
                        userEntity.getLevel().getName(),
                        userEntity.getLevel().getSort(),
                        userEntity.getLevel().getStatus()
                ),
                new OrganizationEntityDto(
                        userEntity.getOrganization().getId(),
                        userEntity.getOrganization().getDepth(),
                        userEntity.getOrganization().getParentId(),
                        userEntity.getOrganization().getStatus(),
                        userEntity.getOrganization().getSort(),
                        userEntity.getOrganization().getName()
                )
        );
    }
    public boolean emailCheck(String email) {
        return userRepository.findByEmail(email)
                .map(userEntity -> {
                    // status가 null인지 확인
                    if (userEntity.getStatus() == null) {
                        return true; // status가 null일 경우 false를 반환하도록 설정
                    }
                    String statusName = userEntity.getStatus().getName();
                    // "재직" 또는 "휴직"이면 false 반환
                    return !(statusName.equals("재직") || statusName.equals("휴직"));
                })
                .orElse(true); // 이메일이 없으면 false 반환
    }

    public boolean store(StoreRequest storeRequest) {
        try {
            // 필요한 엔티티를 매핑
            StatusEntity status = statusRepository.findById(storeRequest.getStatus().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Status ID"));
            LevelEntity level = levelRepository.findById(storeRequest.getLevel().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Level ID"));
            OrganizationEntity organization = organizationRepository.findById(storeRequest.getOrganization().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Organization ID"));

            // UserEntity 생성 후 저장
            UserEntity savedUser = userRepository.save(
                    new UserEntity(
                            storeRequest.getName(),
                            storeRequest.getEmail(),
                            passwordEncoder.encode(storeRequest.getPassword()),
                            "USER",
                            status,
                            level,
                            organization
                    )
            );

            // 저장된 객체가 null이 아닌지 확인하여 성공 여부 반환
            return savedUser != null;
        } catch (Exception e) {
            // 예외 발생 시 false 반환 (저장 실패)
            System.err.println("Error saving user: " + e.getMessage());
            return false;
        }
    }

}
