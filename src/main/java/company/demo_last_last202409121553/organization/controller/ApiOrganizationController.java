package company.demo_last_last202409121553.organization.controller;

import company.demo_last_last202409121553.organization.dto.request.findByParentIdAndDepth.FindByParentIdAndDepthRequest;
import company.demo_last_last202409121553.organization.service.OrganizationService;
import company.demo_last_last202409121553.user.dto.request.findById.FindByIdRequest;
import company.demo_last_last202409121553.user.dto.response.findById.FindByIdResponse;
import company.demo_last_last202409121553.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organization")
public class ApiOrganizationController {

    private final OrganizationService organizationService;
    private final UserService userService;

    @PostMapping("/getOrganizations")
    public ResponseEntity<?> getOrganizations(@Valid @RequestBody FindByParentIdAndDepthRequest request) {
        // 서비스 로직 처리
          return ResponseEntity.ok(organizationService.findByParentIdAndDepth(request.getParent_id(), request.getDepth()));
    }

    @PostMapping("/getUserOrganizations")
    public ResponseEntity<?> getUserOrganizations(@Valid @RequestBody FindByIdRequest request) {
        FindByIdResponse response = userService.findById(request.getId());
        ArrayList<company.demo_last_last202409121553.organization.dto.response.findById.FindByIdResponse> organizations = organizationService.getUserOrganizations(response.getOrganization().getId());
        return ResponseEntity.ok(organizations);
    }

}
