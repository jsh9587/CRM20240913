package company.demo_last_last202409121553.user.controller;


import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.level.service.LevelService;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import company.demo_last_last202409121553.organization.service.OrganizationService;
import company.demo_last_last202409121553.user.entity.StatusEntity;
import company.demo_last_last202409121553.user.entity.UserEntity;
import company.demo_last_last202409121553.user.service.StatusService;
import company.demo_last_last202409121553.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final LevelService levelService;
    private final OrganizationService organizationService;
    private final StatusService statusService;

    @GetMapping("/user")
    public String User(Model model){
        List<UserEntity> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/user";
    }

    @GetMapping("/user/create")
    public String create(){
        return "user/create";
    }

    @GetMapping("/user/edit")
    public String edit(@RequestParam("id") int id, Model model){
        Optional<UserEntity> userOptional = userService.findById(id);
        List<LevelEntity> levels = levelService.findAll();
        List<OrganizationEntity> organizations = organizationService.findAll();
        List<StatusEntity> statuses = statusService.findAll();
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            model.addAttribute("user", user);
            model.addAttribute("levels", levels);
            model.addAttribute("organizations", organizations);
            model.addAttribute("statuses", statuses);
            return "user/edit";
        } else {
            // 사용자를 찾지 못한 경우 처리
            return "redirect:user";  // 또는 에러 페이지로 리다이렉트
        }
    }

}
