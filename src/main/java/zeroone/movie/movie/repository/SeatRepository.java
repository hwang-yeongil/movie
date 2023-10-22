package zeroone.movie.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.movie.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

}
