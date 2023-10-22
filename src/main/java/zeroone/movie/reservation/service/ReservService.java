package zeroone.movie.reservation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import zeroone.movie.reservation.dto.AddReserv;

public interface ReservService {
	ResponseEntity save(AddReserv addReserv);
}
