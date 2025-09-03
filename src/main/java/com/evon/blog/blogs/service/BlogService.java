package com.evon.blog.blogs.service;

import com.evon.blog.blogs.entity.Blog;
import org.springframework.data.domain.Page;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface BlogService {
    Blog createBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    Optional<Blog> getBlogById(Long blogId);

    void deleteBlog(Long blogId);

    Page<Blog> getAllBlog(int page, int size);

    Page<Blog> getBlogByTitle(String title, int page, int size);

    Page<Blog> getBlogByCreatedDate(LocalDateTime date, int page, int size);

    Page<Blog> getBlogByUpdatedDateDate(LocalDateTime date, int page, int size);

    Page<Blog> getBlogByUserId(Long userId, int page, int size);


}