package company.demo_last_last202409121553.company.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyMemberStatusEditRequest {
    @NotNull(message = "담당자 아이디가 누락되었습니다.")
    private int id;
    @NotNull(message = "수정하려는 상태값이 누락되었습니다.")
    private int status;
}
