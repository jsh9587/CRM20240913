package company.demo_last_last202409121553.organization.dto.response.findById;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.organization.entity.OrganizationEntity}
 */
@Value
@Builder // 빌더 패턴 추가
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindByIdParentEntityDto implements Serializable {
    int id;
    String name;
}
