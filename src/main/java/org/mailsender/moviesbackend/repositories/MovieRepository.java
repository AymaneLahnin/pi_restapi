package org.mailsender.moviesbackend.repositories;

import org.mailsender.moviesbackend.entities.EmbededId;
import org.mailsender.moviesbackend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, EmbededId> {
    List<Movie> findByFavoriteTrue();
    List<Movie> findByEmbededIdUserId(Long userId);

    Optional<Movie> findByEmbededId(EmbededId embededId);

}
