package com.evon.blog.blogs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long userId;
    private String title;
    private String description;
    @CreationTimestamp
    @Column(updatable = false)  // Ensure this field is not updated after creation
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;  // Automatically updated on update
}