package company.demo_last_last202409121553.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.List;
@Getter
@Entity(name = "StatusEntity")
@Table(name = "statuses")
public class StatusEntity {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int sort;


    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> users;


}
