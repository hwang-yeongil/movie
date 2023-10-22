package zeroone.movie.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import zeroone.movie.reservation.domain.Reservation;
import zeroone.movie.reservation.repository.ReservRepository;

@Controller
@RequiredArgsConstructor
public class ReservController {
	
	@Autowired
	ReservRepository reservRepository;
	
	@GetMapping("/reservList")
	public String reservList(Model model) {
		List<Reservation> list = reservRepository.findAll();
		model.addAttribute("reservs", list);
		return "content/reservation/reservList";
	}
	
	@GetMapping("addReserv")
	public String addReserv(Long id, Long scr_pk, Long seat_pk, Model model) {
		return "content/reservation/addReserv";
	}
}
