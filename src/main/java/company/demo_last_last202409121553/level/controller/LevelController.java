package company.demo_last_last202409121553.level.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LevelController {

    @GetMapping("/level")
    public String Level(){
        return "level/level";
    }

}
