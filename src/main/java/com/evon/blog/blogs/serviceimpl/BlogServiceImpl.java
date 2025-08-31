package com.evon.blog.blogs.serviceimpl;

import com.evon.blog.blogs.entity.Blog;
import com.evon.blog.blogs.repository.BlogRepository;
import com.evon.blog.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}