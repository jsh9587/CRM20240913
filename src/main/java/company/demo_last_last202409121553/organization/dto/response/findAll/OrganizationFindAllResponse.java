package company.demo_last_last202409121553.organization.dto.response.findAll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link company.demo_last_last202409121553.organization.entity.OrganizationEntity}
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationFindAllResponse implements Serializable {
    private int id;
    private int depth;
    private Integer parent_id;
    private int status;
    private int sort;
    private String name;
    private List<FindAllUserEntityDto> users = new ArrayList<>();
    private List<OrganizationFindAllResponse> children = new ArrayList<>();

    public OrganizationFindAllResponse(int id, String name, int depth, Integer parent_id, int status, int sort, List<FindAllUserEntityDto> users, List<OrganizationFindAllResponse> children) {
        this.id = id;
        this.name = name;
        this.depth = depth;
        this.parent_id = parent_id;
        this.status = status;
        this.sort = sort;
        this.users = users != null ? users : new ArrayList<>(); // Ensure non-null list
        this.children = children != null ? children : new ArrayList<>(); // Ensure non-null list
    }
}
