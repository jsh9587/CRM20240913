package company.demo_last_last202409121553.company.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyMemberFindByIdRequest {
    @NotNull(message = "필수값 누락")
    private int id;
}
