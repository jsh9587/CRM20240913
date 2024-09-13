package company.demo_last_last202409121553.user.entity;

import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "UserEntity")
@Getter
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "email",unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "USER")
    private String roles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="status_id",nullable=false)
    private StatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="level_id",nullable=false)
    private LevelEntity level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="organization_id",nullable=false)
    private OrganizationEntity organization;

}
