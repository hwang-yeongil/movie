package zeroone.movie.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import zeroone.movie.reservation.domain.Reservation;
import zeroone.movie.reservation.dto.AddReserv;
import zeroone.movie.reservation.repository.ReservRepository;
import zeroone.movie.reservation.service.ReservService;

@Controller
@RequiredArgsConstructor
public class ReservController {
	
	@Autowired
	ReservRepository reservRepository;
	private final ReservService reservService;
	
	@GetMapping("/reservList")
	public String reservList(Model model) {
		List<Reservation> list = reservRepository.findAll();
		model.addAttribute("reservs", list);
		return "content/reservation/reservList";
	}
	
	@DeleteMapping("/deleteReserv/{id}")
	public void deleteReserv(@PathVariable Long id) {
		reservRepository.deleteById(id);
	}
	
	@DeleteMapping("/deleteReservAll/{id}")
	public void deleteReservAll(@PathVariable String id) {
		reservService.deleteAll(id);
	}
}
