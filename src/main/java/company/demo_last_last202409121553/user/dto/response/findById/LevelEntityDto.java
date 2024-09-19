package company.demo_last_last202409121553.user.dto.response.findById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.level.entity.LevelEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class LevelEntityDto implements Serializable {
    int id;
    String name;
    int sort;
    int status;
}