package company.demo_last_last202409121553.user.service;

import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.level.repository.LevelRepository;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import company.demo_last_last202409121553.organization.repository.OrganizationRepository;
import company.demo_last_last202409121553.user.dto.request.edit.UserEditRequest;
import company.demo_last_last202409121553.user.dto.request.store.UserStoreRequest;
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
                new StatusEntityDto(userEntity.getStatus().getId(), userEntity.getStatus().getName(), userEntity.getStatus().getSort()),
                new LevelEntityDto(userEntity.getLevel().getId(), userEntity.getLevel().getName(), userEntity.getLevel().getSort(), userEntity.getLevel().getStatus()),
                new OrganizationEntityDto(userEntity.getOrganization().getId(), userEntity.getOrganization().getDepth(), userEntity.getOrganization().getParentId(), userEntity.getOrganization().getStatus(), userEntity.getOrganization().getSort(), userEntity.getOrganization().getName())
        );
    }

    public boolean emailCheck(String email) {
        return userRepository.findByEmail(email)
                .map(userEntity -> {
                    if (userEntity.getStatus() == null) {
                        return true;
                    }
                    String statusName = userEntity.getStatus().getName();
                    return !(statusName.equals("재직") || statusName.equals("휴직"));
                })
                .orElse(true);
    }

    public boolean store(UserStoreRequest storeRequest) {
        try {
            StatusEntity status = statusRepository.findById(storeRequest.getStatus().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Status ID"));
            LevelEntity level = levelRepository.findById(storeRequest.getLevel().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Level ID"));
            OrganizationEntity organization = organizationRepository.findById(storeRequest.getOrganization().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Organization ID"));

            UserEntity user = new UserEntity.Builder()
                    .name(storeRequest.getName())
                    .email(storeRequest.getEmail())
                    .password(passwordEncoder.encode(storeRequest.getPassword()))
                    .roles("USER")
                    .status(status)
                    .level(level)
                    .organization(organization)
                    .build();

            UserEntity savedUser = userRepository.save(user);
            return savedUser != null;
        } catch (Exception e) {
            System.err.println("Error saving user: " + e.getMessage());
            return false;
        }
    }

    public boolean edit(UserEditRequest editRequest) {
        try {
            UserEntity existingUser = userRepository.findById(editRequest.getId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            StatusEntity status = statusRepository.findById(editRequest.getStatus().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Status ID"));
            LevelEntity level = levelRepository.findById(editRequest.getLevel().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Level ID"));
            OrganizationEntity organization = organizationRepository.findById(editRequest.getOrganization().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Organization ID"));

            UserEntity updatedUser = new UserEntity.Builder()
                    .id(existingUser.getId())
                    .name(editRequest.getName())
                    .email(editRequest.getEmail())
                    .password((editRequest.getPassword() != null && !editRequest.getPassword().isEmpty())
                            ? passwordEncoder.encode(editRequest.getPassword())
                            : existingUser.getPassword())
                    .roles("USER")
                    .status(status)
                    .level(level)
                    .organization(organization)
                    .build();

            UserEntity savedUser = userRepository.save(updatedUser);
            return  true;
        } catch (Exception e) {
            System.err.println("Error updating user: " + e.getMessage());
            return false;
        }
    }
}
