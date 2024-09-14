package company.demo_last_last202409121553.user.dto.request.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link company.demo_last_last202409121553.user.entity.StatusEntity}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusEntityDto implements Serializable {
    int id;
    @JsonCreator
    public StatusEntityDto(@JsonProperty("id") int id) {
        this.id = id;
    }
}