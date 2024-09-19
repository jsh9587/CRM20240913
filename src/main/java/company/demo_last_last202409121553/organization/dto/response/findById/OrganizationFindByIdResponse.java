package company.demo_last_last202409121553.organization.dto.response.findById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import company.demo_last_last202409121553.user.entity.UserEntity;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link company.demo_last_last202409121553.organization.entity.OrganizationEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class OrganizationFindByIdResponse implements Serializable {
    int id;
    int depth;
    Integer parent_id;
    int status;
    int sort;
    String name;
    List<FindByIdUserEntityDto> users;
    FindByIdParentEntityDto parent;


}