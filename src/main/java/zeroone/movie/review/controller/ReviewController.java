package zeroone.movie.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import groovy.util.logging.Log;
import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.movie.service.MovieService;
import zeroone.movie.review.domain.Review;
import zeroone.movie.review.repository.ReviewRepository;
import zeroone.movie.review.service.ReviewService;

@Controller

@RequiredArgsConstructor
public class ReviewController {
	
	private MovieService movieService;
	private ReviewService reviewService;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	private ReviewRepository reviewRepository2;
	
	@GetMapping("/addReview")
	public String addReview(Long id, Model model) {
//		public String addReview(Long id, Model model) {
		
		return "content/review/addReview";
	}
	
	@GetMapping("/reviewList")
	public String reviewList(Model model) {
		List<Review> reviews = reviewRepository.findAll();
		model.addAttribute("reviews", reviews);
		return "content/review/reviewList";
	}
//	test
	@GetMapping("/reviewList1")
	public String reviewList1(HttpServletRequest request , Model model) {
		
		Long id = Long.parseLong(request.getParameter("id"));
		List<Review> reviews = reviewService.findListbyid(id);
		model.addAttribute("reviews", reviews);
		return "content/review/reviewList";
	} 
	
	@ResponseBody
	@GetMapping("/list1")
	public List<Review> retrieveAll(){
		return reviewRepository.findAll();
	}
}
