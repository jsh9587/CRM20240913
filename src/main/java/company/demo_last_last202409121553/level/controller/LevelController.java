package company.demo_last_last202409121553.level.controller;


import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.level.service.LevelService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/level/create")
    public String create(){
        return "level/create";
    }

    @GetMapping("/level/edit")
    public String edit(@RequestParam("id") int id, Model model){
        Optional<LevelEntity> levelEntity = levelService.findById(id);
        levelEntity.ifPresent(level -> model.addAttribute("level", level));
        return "level/edit";
    }

}
