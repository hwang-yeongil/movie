package zeroone.movie.review.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import groovy.util.logging.Log;
import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.movie.service.MovieService;
import zeroone.movie.review.domain.Review;
import zeroone.movie.review.dto.DetailDto;
import zeroone.movie.review.dto.ReviewListDto;
import zeroone.movie.review.repository.ReviewRepository;
import zeroone.movie.review.service.ReviewService;

@Controller

@RequiredArgsConstructor
public class ReviewController {
	
	private final MovieService movieService;
	private final ReviewService reviewService;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@GetMapping("/addReview")
	public String addReview(Long id, Model model) {
//		public String addReview(Long id, Model model) {
		return "content/review/addReview";
	}
	
	@GetMapping("/reviewList")
	public String reviewList(Model model) {
		List<ReviewListDto> reviews = reviewService.getAll();
		model.addAttribute("reviews", reviews);
		return "content/review/reviewList";
	}
	
	@GetMapping("/reviewList/{id}")
	public String reviewList1(@PathVariable Long id, Model model) {
		List<ReviewListDto> reviews = reviewService.getAllPk(id);
		model.addAttribute("reviews", reviews);
		model.addAttribute("id",id);
		return "content/review/reviewList";

	}
	
	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model) {
		DetailDto review = reviewService.getDetail(id);
		model.addAttribute("review", review);
		return "content/review/detail";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		DetailDto review = reviewService.getDetail(id);
		model.addAttribute("review", review);
		
		return "content/review/update";
	}

	@ResponseBody
	@GetMapping("/test")
	public List<ReviewListDto> retrieveAll(){
		return reviewService.getAllPk(1L);
		
	}
}
