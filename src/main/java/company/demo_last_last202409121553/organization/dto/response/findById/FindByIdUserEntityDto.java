package company.demo_last_last202409121553.organization.dto.response.findById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.user.entity.UserEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindByIdUserEntityDto implements Serializable {
    int id;
    String name;
    String email;
    String roles;
}