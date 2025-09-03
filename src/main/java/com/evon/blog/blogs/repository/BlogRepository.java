package com.evon.blog.blogs.repository;

import com.evon.blog.blogs.entity.Blog;
import com.evon.blog.users.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    public Optional<Blog> getBlogByTitle(String title);
    public Page<Blog> getBlogByTitle(String title, Pageable pageable);
    public Optional<Blog> getBlogByUserId(Long userId);
    public Page<Blog> getBlogByUserId(Long userId, Pageable pageable);
    public Optional<Blog> getBlogByCreatedDate(LocalDateTime createdDate);
    public Page<Blog> getBlogByCreatedDate(LocalDateTime startDateTime, Pageable pageable);
    public Optional<Blog> getBlogByUpdatedDate(LocalDateTime updatedDate);
    public Page<Blog> getBlogByUpdatedDate(LocalDateTime updatedDate, Pageable pageable);
}