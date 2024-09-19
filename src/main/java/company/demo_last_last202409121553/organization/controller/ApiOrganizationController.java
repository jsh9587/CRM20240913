package company.demo_last_last202409121553.organization.controller;

import company.demo_last_last202409121553.organization.dto.request.edit.OrganizationEditRequest;
import company.demo_last_last202409121553.organization.dto.request.findById.OrganizationFindByIdRequest;
import company.demo_last_last202409121553.organization.dto.request.findByParentIdAndDepth.OrganizationFindByParentIdAndDepthRequest;
import company.demo_last_last202409121553.organization.dto.request.store.OrganizationStoreRequest;
import company.demo_last_last202409121553.organization.dto.response.findById.OrganizationFindByIdResponse;
import company.demo_last_last202409121553.organization.service.OrganizationService;
import company.demo_last_last202409121553.user.dto.request.findById.UserFindByIdRequest;
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
    public ResponseEntity<?> getOrganizations(@Valid @RequestBody OrganizationFindByParentIdAndDepthRequest request) {
        // 서비스 로직 처리
          return ResponseEntity.ok(organizationService.findByParentIdAndDepth(request.getParent_id(), request.getDepth()));
    }

    @PostMapping("/getUserOrganizations")
    public ResponseEntity<?> getUserOrganizations(@Valid @RequestBody UserFindByIdRequest request) {
        FindByIdResponse response = userService.findById(request.getId());
        ArrayList<OrganizationFindByIdResponse> organizations = organizationService.getUserOrganizations(response.getOrganization().getId());
        return ResponseEntity.ok(organizations);
    }

    @PostMapping("/getOrganization")
    public ResponseEntity<?> getOrganization(@Valid @RequestBody OrganizationFindByIdRequest request) {
        // 서비스 로직 처리
        return ResponseEntity.ok(organizationService.findById(request.getId()));
    }

    @PostMapping("/organizationStore")
    public ResponseEntity<?> organizationStore(@Valid @RequestBody OrganizationStoreRequest request) {
        return ResponseEntity.ok(organizationService.store(request));
    }

    @PostMapping("/organizationEdit")
    public ResponseEntity<?> organiztionEdit(@Valid @RequestBody OrganizationEditRequest request){
        return ResponseEntity.ok(organizationService.edit(request));
    }
}
