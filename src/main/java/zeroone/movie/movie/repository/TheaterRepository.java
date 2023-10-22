package zeroone.movie.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.movie.domain.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long>{

}
