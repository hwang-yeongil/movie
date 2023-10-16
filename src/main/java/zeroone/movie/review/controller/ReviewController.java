package zeroone.movie.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	
	@GetMapping("/addReview")
	public String addReview(Long id, Model model) {
		model.addAttribute("movie_pk", id);
		return "content/review/addReview";
	}
}
