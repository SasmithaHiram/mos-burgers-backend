package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customers")

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;

//    @CreatedDate
//    @Column(updatable = false)
//    private LocalDateTime createAt;
//    private LocalDateTime updateAt;

//    @PrePersist
//    protected void onCreate() {
//        createAt = LocalDateTime.now();
//        updateAt = LocalDateTime.now();
//    }

//    @PreUpdate
//    protected void onUpdate() {
//        updateAt = LocalDateTime.now();
//    }

}
