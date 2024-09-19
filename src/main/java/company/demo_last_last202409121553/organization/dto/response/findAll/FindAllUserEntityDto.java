package company.demo_last_last202409121553.organization.dto.response.findAll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.user.entity.UserEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindAllUserEntityDto implements Serializable {
    int id;
    String name;
    String email;
    String password;
    String roles;
}