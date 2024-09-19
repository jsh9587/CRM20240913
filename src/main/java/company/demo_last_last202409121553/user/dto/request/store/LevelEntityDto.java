package company.demo_last_last202409121553.user.dto.request.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.level.entity.LevelEntity}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class LevelEntityDto implements Serializable {
    int id;
    @JsonCreator
    public LevelEntityDto(@JsonProperty("id") int id) {
        this.id = id;
    }
}