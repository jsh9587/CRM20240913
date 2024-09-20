package company.demo_last_last202409121553.company.controller.api;

import company.demo_last_last202409121553.company.dto.request.CompanyEditRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyStoreRequest;
import company.demo_last_last202409121553.company.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class ApiCompanyController {
    private final CompanyService companyService;
    public ApiCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companyStore")
    public ResponseEntity<?> store(@Valid @RequestBody CompanyStoreRequest request){
        return ResponseEntity.ok(companyService.store(request));
    }

    @PostMapping("/companyEdit")
    public ResponseEntity<?> edit(@Valid @RequestBody CompanyEditRequest request){
        return ResponseEntity.ok(companyService.edit(request));
    }
}
