package company.demo_last_last202409121553.organization.controller;


import company.demo_last_last202409121553.organization.dto.response.findAll.OrganizationFindAllResponse;
import company.demo_last_last202409121553.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrganizationController {
    private final  OrganizationService organizationService;

    @GetMapping("/organization")
    public String Organization(Model model){
        List<OrganizationFindAllResponse> response = organizationService.getOrganizationHierarchy();
        model.addAttribute("organizationList", response);
        return "organization/organization";
    }

}
