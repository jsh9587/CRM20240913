package company.demo_last_last202409121553.organization.dto.request.edit;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrganizationEditRequest {

    @NotNull(message = "수정하려는 ID 는 필수 값입니다.")
    private int id;
    @NotEmpty(message = "조직명을 입력해주세요.")
    private String name;
    @NotNull(message = "뎁스를 입력해주세요.")
    @Max(4)
    @Min(1)
    private int depth;
    @NotNull(message = "순번을 입력해주세요")
    private int sort;
    @NotNull(message = "사용유무를 선택해주세요")
    private int status;

    private Integer parent_id;
}
