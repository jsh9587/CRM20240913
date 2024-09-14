package company.demo_last_last202409121553.user.dto.response.findById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.organization.entity.OrganizationEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationEntityDto implements Serializable {
    int id;
    int depth;
    @Min(0)
    int parentId;
    int status;
    int sort;
    String name;
}