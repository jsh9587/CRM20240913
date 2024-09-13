package company.demo_last_last202409121553.config.runner;

import company.demo_last_last202409121553.config.runner.UserPasswordEncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderRunner implements CommandLineRunner {

    private final UserPasswordEncoderService userPasswordEncoderService;

    @Autowired
    public PasswordEncoderRunner(UserPasswordEncoderService userPasswordEncoderService) {
        this.userPasswordEncoderService = userPasswordEncoderService;
    }

    @Override
    public void run(String... args) {
        userPasswordEncoderService.encodeAllUserPasswords();
        System.out.println("All user passwords have been encoded.");
    }
}