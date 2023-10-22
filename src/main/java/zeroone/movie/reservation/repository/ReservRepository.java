package zeroone.movie.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.reservation.domain.Reservation;

public interface ReservRepository extends JpaRepository<Reservation, Long>{

}
