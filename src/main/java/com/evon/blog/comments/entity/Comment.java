package com.evon.blog.comments.entity;

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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long blogId;
    private String body;
    @CreationTimestamp
    @Column(updatable = false)  // Ensure this field is not updated after creation
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;  // Automatically updated on update
}