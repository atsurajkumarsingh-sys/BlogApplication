package com.evon.blog.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String userName;
    @CreationTimestamp
    @Column(updatable = false)  // Ensure this field is not updated after creation
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;  // Automatically updated on update
}