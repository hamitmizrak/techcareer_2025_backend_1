package com.hamitmizrak.techcareer_2025_backend_1.jwt;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

// LOMBOK
@Getter
@Setter
@ToString
//@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

// Entity
@Entity(name = "Userses") // JPQL için kullanacağım.
@Table(name = "useres")  // Native Query için kullanacağım.
public class _4_UserEntity {

    // Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    // USERNAME
    @Column(nullable = false, unique = true)
    private String username;

    // PASSWORD
    @Column(nullable = false)
    private String password;

    // ROLE
    // Enum datasunu String olarak kaydet
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private _3_Role role;

    // Default olarak: Enum için User olsun
    @PrePersist
    public void setDefaultRole(){
        if(this.role == null){
            this.role=_3_Role.USER;
        }
    }

    // DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="creat_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

}
