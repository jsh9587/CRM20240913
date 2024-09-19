package company.demo_last_last202409121553.user.dto.request.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.user.entity.UserEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserStoreRequest implements Serializable {
    private int id;
    @NotEmpty(message = "이름은 필수값 입니다")
    private String name;
    @NotNull(message = "이메일은 필수값 입니다")
    private String email;
    @NotEmpty(message = "비밀번호는 필수값 입니다.")
    private String password;
    @NotNull(message = "상태 값은 필수입니다.")  // 추가 유효성 검사
    private StatusEntityDto status;

    @NotNull(message = "레벨 값은 필수입니다.")  // 추가 유효성 검사
    private LevelEntityDto level;

    @NotNull(message = "조직 값은 필수입니다.")  // 추가 유효성 검사
    private OrganizationEntityDto organization;
}