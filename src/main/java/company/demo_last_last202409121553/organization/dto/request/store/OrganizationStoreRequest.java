package company.demo_last_last202409121553.organization.dto.request.store;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationStoreRequest {

    private int id;
    @NotEmpty(message = "조직명은 필수 값 입니다.")
    private String name;
    @NotNull(message =  "순번을 입력해주세요")
    @Min(0)
    private int sort;
    @Max(4)
    @Min(1)
    @NotNull(message = "뎁스를 입력해주세요")
    private int depth;
    @Min(0)
    @NotNull(message = "사용유무를 선택해주세요")
    private int status;
    private Integer parent_id;

}
