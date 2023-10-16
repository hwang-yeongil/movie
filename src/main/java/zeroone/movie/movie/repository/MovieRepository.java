package zeroone.movie.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.movie.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	Optional<Movie> findById(Long movie_pk);
}
