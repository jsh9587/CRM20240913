package company.demo_last_last202409121553.company.controller.api;

import company.demo_last_last202409121553.company.dto.request.CompanyMemberEditRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyMemberFindByIdRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyMemberStatusEditRequest;
import company.demo_last_last202409121553.company.dto.request.CompanyMemberStoreRequest;
import company.demo_last_last202409121553.company.service.CompanyMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/companyMember")
public class ApiCompanyMemberController {

    private final CompanyMemberService companyMemberService;
    public ApiCompanyMemberController(CompanyMemberService companyMemberService) {
        this.companyMemberService = companyMemberService;
    }

    @PostMapping("/memberStore")
    public ResponseEntity<?> store(@Valid @RequestBody CompanyMemberStoreRequest request){
        return ResponseEntity.ok(companyMemberService.store(request));
    }

    @PostMapping("/memberStatusEdit")
    public ResponseEntity<?> statusEdit(@Valid @RequestBody CompanyMemberStatusEditRequest request){
        return ResponseEntity.ok(companyMemberService.statusEdit(request));
    }

    @PostMapping("/memberEdit")
    public ResponseEntity<?> edit(@Valid @RequestBody CompanyMemberEditRequest request){
        return ResponseEntity.ok(companyMemberService.edit(request));
    }

    @PostMapping("/member")
    public ResponseEntity<?> findById(@Valid @RequestBody CompanyMemberFindByIdRequest request){
        return ResponseEntity.ok(companyMemberService.findById(request.getId()));
    }

}
