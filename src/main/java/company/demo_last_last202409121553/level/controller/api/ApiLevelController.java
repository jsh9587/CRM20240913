package company.demo_last_last202409121553.level.controller.api;


import company.demo_last_last202409121553.level.dto.request.LevelEditRequest;
import company.demo_last_last202409121553.level.dto.request.LevelStoreRequest;
import company.demo_last_last202409121553.level.service.LevelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/level")
public class ApiLevelController {
    private final LevelService levelService;
    public ApiLevelController(LevelService levelService) {
        this.levelService = levelService;
    }
    @PostMapping("/levelStore")
    public ResponseEntity<?> levelStore(@Valid @RequestBody LevelStoreRequest levelRequest) {
        return ResponseEntity.ok(levelService.store(levelRequest));
    }

    @PostMapping("/levelEdit")
    public ResponseEntity<?> levelEdit(@Valid @RequestBody LevelEditRequest levelRequest) {
        return ResponseEntity.ok(levelService.edit(levelRequest));
    }
}
