package company.demo_last_last202409121553.dashboard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashBoardController {
    @GetMapping("/")
    public String dashboard() {
        return "dashboard/dashboard";
    }
}
