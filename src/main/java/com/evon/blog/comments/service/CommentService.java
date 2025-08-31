package com.evon.blog.comments.service;

import com.evon.blog.comments.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment updateComment(Long id, Comment comment);

    List<Comment> getAllComment();

    Optional<Comment> getCommentById(Long commentId);

    void deleteComment(Long commentId);
}