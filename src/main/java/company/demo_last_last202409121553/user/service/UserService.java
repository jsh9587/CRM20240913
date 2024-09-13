package company.demo_last_last202409121553.user.service;

import company.demo_last_last202409121553.user.entity.UserEntity;
import company.demo_last_last202409121553.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public Optional<UserEntity> findById(int id) {
        return userRepository.findById(id);
    }
}
