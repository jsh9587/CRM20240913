package company.demo_last_last202409121553.login.service;

import company.demo_last_last202409121553.login.entity.LoginUser;
import company.demo_last_last202409121553.login.repository.LoginUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginUserRepository userRepository;

    public Optional<LoginUser> findOne(String email) {
        return userRepository.findByEmail(email);
    }
}
