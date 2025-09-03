package com.evon.blog.blogs.serviceimpl;

import com.evon.blog.blogs.entity.Blog;
import com.evon.blog.blogs.repository.BlogRepository;
import com.evon.blog.blogs.service.BlogService;
import com.evon.blog.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog updatedBlog) {
        return blogRepository.findById(id).map(blog -> {
            blog.setTitle(updatedBlog.getTitle());
            blog.setDescription(updatedBlog.getDescription());
            return blogRepository.save(blog);
        }).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    @Override
    public Optional<Blog> getBlogById(Long blogId) {
        return blogRepository.findById(blogId);
    }

    @Override
    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
    }

    @Override
    public Page<Blog> getAllBlog(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> getBlogByTitle(String title, int page, int size) {
        if(blogRepository.getBlogByTitle(title).isEmpty()) {
            throw new ResourceNotFoundException("Record not found");
        }
        return blogRepository.getBlogByTitle(title, PageRequest.of(page, size));
    }

    @Override
    public Page<Blog> getBlogByCreatedDate(LocalDateTime createdDate, int page, int size) {
        /*LocalDate startOfDay = LocalDate.from(createdDate.atStartOfDay());
        LocalDate endOfDay = LocalDate.from(createdDate.atTime(23, 59, 59));*/
        if(blogRepository.getBlogByCreatedDate(createdDate).isEmpty()) {
            throw new ResourceNotFoundException("Record not found");
        }
        return blogRepository.getBlogByCreatedDate(createdDate, PageRequest.of(page, size));
    }

    @Override
    public Page<Blog> getBlogByUpdatedDateDate(LocalDateTime date, int page, int size) {
        if(blogRepository.getBlogByUpdatedDate(date).isEmpty()) {
            throw new ResourceNotFoundException("Record not found");
        }
        return blogRepository.getBlogByUpdatedDate(date, PageRequest.of(page, size));
    }

    @Override
    public Page<Blog> getBlogByUserId(Long userId, int page, int size) {
        if(blogRepository.getBlogByUserId(userId).isEmpty()) {
            throw new ResourceNotFoundException("Record not found");
        }
        return blogRepository.getBlogByUserId(userId, PageRequest.of(page, size));
    }
}