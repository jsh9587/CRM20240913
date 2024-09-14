package company.demo_last_last202409121553.user.controller.api;


import company.demo_last_last202409121553.user.dto.request.edit.EditRequest;
import company.demo_last_last202409121553.user.dto.request.findByEmail.FindByEmailRequest;
import company.demo_last_last202409121553.user.dto.request.store.StoreRequest;
import company.demo_last_last202409121553.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class ApiUserController {

    private final UserService userService;

    @PostMapping("/emailCheck")
    public ResponseEntity<Boolean> emailCheck(@RequestBody FindByEmailRequest request) {
        return ResponseEntity.ok(userService.emailCheck(request.getEmail()));
    }

    @PostMapping("/userStore")
    public ResponseEntity<?> userStore(@Valid @RequestBody StoreRequest request) {
        try {
            boolean isSuccess = userService.store(request);

            if (isSuccess) {
                // 성공 시
                return ResponseEntity.ok("User successfully stored");
            } else {
                // 저장 실패 시
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User storage failed");
            }
        } catch (IllegalArgumentException e) {
            // 잘못된 입력 데이터에 대한 예외 처리
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // 기타 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
        }
    }
    @PostMapping("/userEdit")
    public ResponseEntity<?> userEdit(@Valid @RequestBody EditRequest request) {
        try {
            boolean isSuccess = userService.edit(request);

            if (isSuccess) {
                // 성공 시
                return ResponseEntity.ok("User successfully Edit");
            } else {
                // 저장 실패 시
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User Edit failed");
            }
        } catch (IllegalArgumentException e) {
            // 잘못된 입력 데이터에 대한 예외 처리
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // 기타 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
        }
    }
}
