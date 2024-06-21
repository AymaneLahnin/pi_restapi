package org.mailsender.moviesbackend.controllers;


import org.mailsender.moviesbackend.entities.Comment;
import org.mailsender.moviesbackend.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/movies")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{id}")
    public List<Comment> getComments(@PathVariable Long id) {
        return commentService.getCommentsByRef(id);
    }

    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @GetMapping("/comment/{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/comment/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        return commentService.updateComment(id, updatedComment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
