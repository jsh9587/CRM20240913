package company.demo_last_last202409121553.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "UserEntity")
@Getter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "USER")
    private String roles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private StatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private LevelEntity level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private OrganizationEntity organization;

    public UserEntity(String name, String email, String password, String user, StatusEntity status, LevelEntity level, OrganizationEntity organization) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = user;
        this.status = status;
        this.level = level;
        this.organization = organization;
    }
}
