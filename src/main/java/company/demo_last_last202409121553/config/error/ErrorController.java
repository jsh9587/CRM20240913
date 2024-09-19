package company.demo_last_last202409121553.config.error;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/403")
    public String forbidden() {
        return "403"; // 403.jsp 파일이 /WEB-INF/views/403.jsp에 있어야 합니다.
    }
}
