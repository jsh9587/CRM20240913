package company.demo_last_last202409121553.organization.dto.request.findByParentIdAndDepth;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class OrganizationFindByParentIdAndDepthRequest {

    private Integer parent_id;
    @NotNull(message = "depth는 필수 값입니다.")
    @Positive(message = "depth는 양수여야 합니다.")
    private int depth;

}
