package company.demo_last_last202409121553.company.controller;

import company.demo_last_last202409121553.company.entity.CompanyEntity;
import company.demo_last_last202409121553.company.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CompanyController {
    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/company")
    public String company(Model model) {
        List<CompanyEntity> companys = companyService.findAll();
        model.addAttribute("companys", companys);
        return "company/company";
    }

    @GetMapping("/company/create")
    public String create() {
        return "company/create";
    }

    @GetMapping("/company/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Optional<CompanyEntity> company = companyService.findById(id);
        model.addAttribute("company", company.get());
        return "company/edit";
    }
    @GetMapping("/company/member")
    public String member(@RequestParam("id") int id, Model model) {
        Optional<CompanyEntity> company = companyService.findById(id);
        model.addAttribute("company", company.get());
        return "company/member";
    }
}
