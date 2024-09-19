package company.demo_last_last202409121553.user.dto.request.findByEmail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.user.entity.UserEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserFindByEmailRequest implements Serializable {
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;
}