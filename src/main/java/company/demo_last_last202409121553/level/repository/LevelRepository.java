package company.demo_last_last202409121553.level.repository;

import company.demo_last_last202409121553.level.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<LevelEntity, Integer> {
    Optional<LevelEntity> findById(int id);
}
