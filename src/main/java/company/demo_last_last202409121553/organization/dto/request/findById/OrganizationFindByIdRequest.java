package company.demo_last_last202409121553.organization.dto.request.findById;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrganizationFindByIdRequest {
    @NotNull(message = "ID는 필수값 입니다.")
    private int id;
}
