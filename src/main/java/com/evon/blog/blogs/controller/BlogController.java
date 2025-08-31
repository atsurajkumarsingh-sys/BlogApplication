package com.evon.blog.blogs.controller;

import com.evon.blog.blogs.entity.Blog;
import com.evon.blog.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/api/createBlog")
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @PutMapping("/api/updateBlog")
    public Blog updateBlog(@RequestParam Long id, @RequestBody Blog blog){
        return blogService.updateBlog(id, blog);
    }

    @GetMapping("/api/getBlogById")
    public Optional<Blog> getBlogById(@RequestParam Long id){
        return blogService.getBlogById(id);
    }

    @DeleteMapping("/api/deleteBlog")
    public void deleteBlog(@RequestParam Long id){
        blogService.deleteBlog(id);
    }

    @GetMapping("/api/getAllBlogs")
    public ResponseEntity<Page<Blog>> getAllBlogs(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size){
        Page<Blog> blogs =  blogService.getAllBlog(page, size);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}