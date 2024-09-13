package company.demo_last_last202409121553.organization.entity;

import company.demo_last_last202409121553.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity(name = "OrganizationEntity")
@Table(name = "organizations")
@Getter
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 4,nullable = false)
    private int depth;
    @Column(name="parent_id", nullable = false)
    private int parentId;
    @Column(nullable = false)
    private int status;
    @Column(nullable = false)
    private int sort;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> users;
}
