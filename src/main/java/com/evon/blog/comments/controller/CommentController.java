package com.evon.blog.comments.controller;

import com.evon.blog.comments.entity.Comment;
import com.evon.blog.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/api/createComment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @PutMapping("/api/updateComment")
    public Comment updateComment(@RequestParam Long id, @RequestBody Comment comment){
        return commentService.updateComment(id, comment);
    }

    @GetMapping("/api/getCommentById")
    public Optional<Comment> getCommentById(@RequestParam Long id){
        return commentService.getCommentById(id);
    }

    @GetMapping("/api/getAllComment")
    public List<Comment> getAllComment(){
        return commentService.getAllComment();
    }

    @DeleteMapping("/api/deleteComment")
    public void deleteComment(@RequestParam Long id){
        commentService.deleteComment(id);
    }
}