package company.demo_last_last202409121553.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import company.demo_last_last202409121553.level.entity.LevelEntity;
import company.demo_last_last202409121553.organization.entity.OrganizationEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "UserEntity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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



    // UserEntity의 생성자
    private UserEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.roles = builder.roles;
        this.status = builder.status;
        this.level = builder.level;
        this.organization = builder.organization;
    }

    // Builder 클래스 생성
    public static class Builder {
        private int id;
        private String name;
        private String email;
        private String password;
        private String roles;
        private StatusEntity status;
        private LevelEntity level;
        private OrganizationEntity organization;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder roles(String roles) {
            this.roles = roles;
            return this;
        }

        public Builder status(StatusEntity status) {
            this.status = status;
            return this;
        }

        public Builder level(LevelEntity level) {
            this.level = level;
            return this;
        }

        public Builder organization(OrganizationEntity organization) {
            this.organization = organization;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
