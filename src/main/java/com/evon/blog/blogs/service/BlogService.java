package com.evon.blog.blogs.service;

import com.evon.blog.blogs.entity.Blog;
import org.springframework.data.domain.Page;


import java.util.Optional;

public interface BlogService {
    Blog createBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    Optional<Blog> getBlogById(Long blogId);

    void deleteBlog(Long blogId);

    Page<Blog> getAllBlog(int page, int size);
}