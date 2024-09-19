package company.demo_last_last202409121553.level.controller;


import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.level.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/level")
    public String Level(Model model){
        List<LevelEntity> levels = levelService.findAll();
        model.addAttribute("levels", levels);
        return "level/level";
    }

}
