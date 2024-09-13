package company.demo_last_last202409121553.level.service;

import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.level.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    private final LevelRepository levelRepository;
    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
    public List<LevelEntity> findAll(){
        return levelRepository.findAll();
    }
}
