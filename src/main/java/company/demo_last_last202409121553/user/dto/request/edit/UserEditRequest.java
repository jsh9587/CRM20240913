package company.demo_last_last202409121553.user.dto.request.edit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.user.entity.UserEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEditRequest implements Serializable {
    int id;
    String name;
    String email;
    String password;
    StatusEntityDto status;
    LevelEntityDto level;
    OrganizationEntityDto organization;

    public UserEditRequest(int id, String name, String email, String password, StatusEntityDto status, LevelEntityDto level, OrganizationEntityDto organization) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.level = level;
        this.organization = organization;
    }
}