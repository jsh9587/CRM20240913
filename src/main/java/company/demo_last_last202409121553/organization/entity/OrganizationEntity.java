package company.demo_last_last202409121553.organization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import company.demo_last_last202409121553.user.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "OrganizationEntity")
@Table(name = "organizations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 4,nullable = false)
    private int depth;
    @Column(name="parent_id")
    private Integer  parentId;
    @Column(nullable = false)
    private int status;
    @Column(nullable = false)
    private int sort;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserEntity> users;

    // 부모 조직 설정 (ManyToOne 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false) // parent_id와 매핑
    private OrganizationEntity parent; // 상위 조직(부모)

    // 자식 조직들을 위한 관계 설정 (옵션)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<OrganizationEntity> children;

    private OrganizationEntity(OrganizationEntity.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.depth = builder.depth;
        this.parentId = builder.parentId;
        this.sort = builder.sort;
        this.status = builder.status;
    }

    public static class Builder{
        private int id;
        private String name;
        private int depth;
        private Integer parentId;
        private int status;
        private int sort;
        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder depth(int depth){
            this.depth = depth;
            return this;
        }
        public Builder parentId(Integer parentId){
            this.parentId = parentId;
            return this;
        }
        public Builder status(int status){
            this.status = status;
            return this;
        }
        public Builder sort(int sort){
            this.sort = sort;
            return this;
        }
        public OrganizationEntity build(){
            return new OrganizationEntity(this);
        }
    }
}
