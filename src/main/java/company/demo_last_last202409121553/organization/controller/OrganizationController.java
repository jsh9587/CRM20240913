package company.demo_last_last202409121553.organization.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class OrganizationController {

    @GetMapping("/organization")
    public String Organization(){
        return "organization/organization";
    }

}
