package org.mailsender.moviesbackend.repositories;



import org.mailsender.moviesbackend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findByRef(Long id);
}
