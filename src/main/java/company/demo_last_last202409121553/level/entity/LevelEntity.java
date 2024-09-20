package company.demo_last_last202409121553.level.entity;

import company.demo_last_last202409121553.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "LevelEntity")
@Table(name="levels")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<UserEntity> users;

    // Builder 패턴 사용
    private LevelEntity(LevelEntity.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sort = builder.sort;
        this.status = builder.status;
        this.users = builder.users;
    }

    public static class Builder{
        private int id;
        private String name;
        private int sort;
        private int status;
        private List<UserEntity> users;
        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder sort(int sort){
            this.sort = sort;
            return this;
        }
        public Builder status(int status){
            this.status = status;
            return this;
        }
        public Builder users(List<UserEntity> users){
            this.users = users;
            return this;
        }
        public LevelEntity build(){
            LevelEntity levelEntity = new LevelEntity();
            levelEntity.id = id;
            levelEntity.name = name;
            levelEntity.sort = sort;
            levelEntity.status = status;
            levelEntity.users = users;
            return levelEntity;
        }
    }
}
