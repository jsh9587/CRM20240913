package company.demo_last_last202409121553.user.repository;

import company.demo_last_last202409121553.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAll();
}
