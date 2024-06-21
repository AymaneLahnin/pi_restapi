package org.mailsender.moviesbackend.services;



import org.mailsender.moviesbackend.entities.Comment;
import org.mailsender.moviesbackend.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService{

    @Autowired
    private CommentaireRepository commentaireRepository;

    public List<Comment> getCommentsByRef(Long ref) {
        return commentaireRepository.findByRef(ref);
    }


    public Comment addComment(Comment comment) {
        return commentaireRepository.save(comment);
    }


    public Comment getCommentById(Long id) {
        Optional<Comment> optionalComment = commentaireRepository.findById(id);
        return optionalComment.orElse(null);
    }


    public Comment updateComment(Long id, Comment updatedComment) {
        if (commentaireRepository.existsById(id)) {
            updatedComment.setId(id);
            return commentaireRepository.save(updatedComment);
        }
        return null;
    }

    public void deleteComment(Long id) {
        commentaireRepository.deleteById(id);
    }
}
