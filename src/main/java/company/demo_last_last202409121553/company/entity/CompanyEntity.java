package company.demo_last_last202409121553.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "CompanyEntity")
@Table(name = "company")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;

    @Column(name = "business_license", length = 50, nullable = false ,updatable = false ,unique = true)
    private String businessLicense;

    @Column(name = "category")
    private String category;

    @Column(length = 50)
    private String owner;

    @Column(length = 100)
    private String address;

    @Column(name = "business_type", length = 100)
    private String businessType;

    @Column(name = "business_item", length = 100)
    private String businessItem;

    @CreatedDate
    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt; // camelCase로 수정

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt; // camelCase로 수정

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CompanyMemberEntity> members;


    private CompanyEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.businessLicense = builder.businessLicense;
        this.address = builder.address;
        this.businessType = builder.businessType;
        this.businessItem = builder.businessItem;
        this.category = builder.category;
        this.owner = builder.owner;
    }

    public static class Builder {
        private int id;
        private String name;
        private String businessLicense;
        private String owner;
        private String address;
        private String businessType;
        private String businessItem;
        private String category;

        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder businessLicense(String businessLicense) {
            this.businessLicense = businessLicense;
            return this;
        }
        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }
        public Builder businessItem(String businessItem) {
            this.businessItem = businessItem;
            return this;
        }
        public Builder category(String category) {
            this.category = category;
            return this;
        }
        public CompanyEntity build() {
            return new CompanyEntity(this);
        }
    }
}
