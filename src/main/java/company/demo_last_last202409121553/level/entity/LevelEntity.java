package company.demo_last_last202409121553.level.entity;

import company.demo_last_last202409121553.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "LevelEntity")
@Table(name="levels")
@Getter
public class LevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int sort;
    @Column(nullable = false)
    private int status;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> users;
}
