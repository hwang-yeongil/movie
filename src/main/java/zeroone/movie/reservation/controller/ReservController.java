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
	private ReservRepository reservRepository;
	
	@GetMapping("/reservList")
	public String reservList(Model model) {
		List<Reservation> list = reservRepository.findAll();
		model.addAttribute("Reserv", list);
		return "content/reservList";
	}
}
