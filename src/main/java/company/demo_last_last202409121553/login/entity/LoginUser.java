package company.demo_last_last202409121553.login.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    private String roles;

}