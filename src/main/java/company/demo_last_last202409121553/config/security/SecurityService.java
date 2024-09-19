package company.demo_last_last202409121553.config.security;

import company.demo_last_last202409121553.login.entity.LoginUser;
import company.demo_last_last202409121553.login.service.LoginService;
import company.demo_last_last202409121553.user.entity.RoleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class SecurityService implements UserDetailsService {

    private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername:" + email);
        Optional<LoginUser> findOne = loginService.findOne(email);
        log.info("findOne : {}", findOne);
        LoginUser newUser = findOne.orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 ID입니다."));
        System.out.println("newUser:" + newUser);

        // Convert RoleEnum to String array
        Set<RoleEnum> roleEnums = newUser.getRoles();
        String[] roles = roleEnums.stream()
                .map(Enum::name)
                .toArray(String[]::new);

        return User.builder()
                .username(newUser.getEmail())
                .password(newUser.getPassword())
                .roles(roles)  // Use String array for roles
                .build();
    }

//    public LoginUser createUser(String email, String name, String password, PasswordEncoder passwordEncoder) {
//        LoginUser newMember = new LoginUser();
//        newMember.setEmail(email);
//        newMember.setName(name);
//        newMember.setPassword(passwordEncoder.encode(password));
//        newMember.setRoles("USER");
//        return newMember;
//    }

}