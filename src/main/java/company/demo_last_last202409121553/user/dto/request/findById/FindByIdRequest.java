package company.demo_last_last202409121553.user.dto.request.findById;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FindByIdRequest {

    @NotNull(message = "USER_ID는 필수 값입니다.")
    private int id;

}
