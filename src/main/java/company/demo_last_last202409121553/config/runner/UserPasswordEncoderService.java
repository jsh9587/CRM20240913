package company.demo_last_last202409121553.config.runner;


import company.demo_last_last202409121553.login.entity.LoginUser;
import company.demo_last_last202409121553.login.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserPasswordEncoderService {

    private final LoginUserRepository newUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserPasswordEncoderService(LoginUserRepository newUserRepository, PasswordEncoder passwordEncoder) {
        this.newUserRepository = newUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void encodeAllUserPasswords() {
        List<LoginUser> users = newUserRepository.findAll();
        for (LoginUser user : users) {
            // Encode the password if it hasn't been encoded yet
            if (!user.getPassword().startsWith("{bcrypt}")) {
                String rawPassword = user.getPassword();
                String encodedPassword = passwordEncoder.encode(rawPassword);
                user.setPassword(encodedPassword);
                newUserRepository.save(user); // Save the updated user
            }
        }
    }
}