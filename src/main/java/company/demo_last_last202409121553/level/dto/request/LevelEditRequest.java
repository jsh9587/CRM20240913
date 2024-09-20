package company.demo_last_last202409121553.level.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LevelEditRequest {
    @NotNull(message = "수정하려는 직책의 ID 값은 필수 입니다.")
    private int id;
    @NotEmpty(message = "직책명은 필수값입니다")
    private String name;
    @NotNull(message = "순서는 필수값입니다")
    @Min(1)
    private int sort;
    @NotNull(message = "사용유무를 선택해주세요")
    @Min(0)
    private int status;
}
