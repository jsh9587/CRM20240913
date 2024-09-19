package company.demo_last_last202409121553.login.entity;

import company.demo_last_last202409121553.user.entity.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "login_users")
@Data
@Table(name = "users")
public class LoginUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "email",unique = true)
    private String email;

    private String password;

    // roles를 Enum 타입으로 저장
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<RoleEnum> roles = new HashSet<>();

}