package company.demo_last_last202409121553.company.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity(name = "CompanyMemberEntity")
@Table(name = "company_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class CompanyMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String title;

    @Column(nullable = false)
    private String hphone;

    @Column(nullable = false)
    private String email;

    private String tel;
    private String fax;
    private String address;
    private int status;

    @CreatedDate
    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt; // camelCase로 수정

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt; // camelCase로 수정


    // ManyToOne relationship with CompanyEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company; // The company that this member belongs to

    private CompanyMemberEntity(Builder builder) {
        this.name = builder.name;
        this.title = builder.title;
        this.hphone = builder.hphone;
        this.email = builder.email;
        this.tel = builder.tel;
        this.fax = builder.fax;
        this.address = builder.address;
        this.status = builder.status;
        this.company = builder.company;
    }

    public static class Builder{
        private int id;
        private String name;
        private String title;
        private String hphone;
        private String email;
        private String tel;
        private String fax;
        private String address;
        private int status;
        private CompanyEntity company;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder hphone(String hphone){
            this.hphone = hphone;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder tel(String tel){
            this.tel = tel;
            return this;
        }
        public Builder fax(String fax){
            this.fax = fax;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder status(int status){
            this.status = status;
            return this;
        }
        public Builder company(CompanyEntity company){
            this.company = company;
            return this;
        }
        public CompanyMemberEntity build(){
            return new CompanyMemberEntity(this);
        }
    }
    public void updateStatus(int status) {
        this.status = status;
    }
}
