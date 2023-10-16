package zeroone.movie.movie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.repository.MovieRepository;

@Controller
@RequiredArgsConstructor
public class MovieController {
	
	private final MovieRepository movieRepository;
	
	@GetMapping("/movieList")
	public String movieList(Model model) {
		List<Movie> movies = movieRepository.findAll();
		model.addAttribute("movies", movies);
		return "content/movieList";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		List<Movie> movies = movieRepository.findAll();
		model.addAttribute("movies", movies);
		return "content/index";
	}
}
