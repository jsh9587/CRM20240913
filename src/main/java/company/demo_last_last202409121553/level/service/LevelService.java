package company.demo_last_last202409121553.level.service;

import company.demo_last_last202409121553.level.dto.request.LevelEditRequest;
import company.demo_last_last202409121553.level.dto.request.LevelStoreRequest;
import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.level.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService {
    private final LevelRepository levelRepository;
    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
    public List<LevelEntity> findAll(){
        return levelRepository.findAll();
    }
    public Optional<LevelEntity> findById(int id){
        return levelRepository.findById(id);
    }

    public boolean store(LevelStoreRequest request) {
        try {
            LevelEntity levelEntity = new LevelEntity.Builder()
                    .id(request.getId())
                    .name(request.getName())
                    .sort(request.getSort())
                    .status(request.getStatus())
                    .build();

            levelRepository.save(levelEntity);
            return true;
        } catch (IllegalArgumentException e) {
            throw e; // Rethrow to be caught by the controller
        } catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean edit(LevelEditRequest request) {
        try{
            Optional<LevelEntity> levelEntity = Optional.ofNullable(levelRepository.findById(request.getId())
                    .orElseThrow(() -> new IllegalArgumentException("수정하려는 직책을 찾을 수 없습니다.")));

            if( request.getStatus() == 1 && !levelEntity.get().getUsers().isEmpty() ){
               throw new IllegalArgumentException("미사용으로 수정하려는 직책에 속한 유저가 있습니다.");
            }
            LevelEntity levelEntityToEdit = new LevelEntity.Builder()
                    .id(request.getId())
                    .sort(request.getSort())
                    .name(request.getName())
                    .status(request.getStatus())
                    .build();
            levelRepository.save(levelEntityToEdit);
            return true;
        } catch (IllegalArgumentException e) {
            throw e; // Rethrow to be caught by the controller
        } catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }
    }

}
