package company.demo_last_last202409121553.login.repository;

import company.demo_last_last202409121553.login.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {

    Optional<LoginUser> findByEmail(String email);
}
