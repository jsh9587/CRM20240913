package company.demo_last_last202409121553.organization.controller;

import company.demo_last_last202409121553.organization.dto.request.FindByParentIdAndDepth;
import company.demo_last_last202409121553.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organization")
public class ApiOrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/getOrganizations")
    public ResponseEntity<?> getOrganizations(@Valid @RequestBody FindByParentIdAndDepth request) {
        // 서비스 로직 처리
          return ResponseEntity.ok(organizationService.findByParentIdAndDepth(request.getParent_id(), request.getDepth()));
    }

}
