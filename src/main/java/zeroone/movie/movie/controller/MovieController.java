package zeroone.movie.movie.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.dto.DateDto;
import zeroone.movie.movie.dto.MovieDto;
import zeroone.movie.movie.dto.TheaterDto;
import zeroone.movie.movie.repository.MovieRepository;
import zeroone.movie.movie.repository.ScreenRepository;
import zeroone.movie.movie.service.ScreenService;

@Controller
@RequiredArgsConstructor
public class MovieController {
	
	private final MovieRepository movieRepository;
	private final ScreenService screenService;
	@Autowired
	ScreenRepository screenRepository;
		
	@GetMapping("/movieList")
	public String movieList(Model model) {
		List<Movie> movies = movieRepository.findAll();
		model.addAttribute("movies", movies);
		return "content/movieList";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		List<Movie> movies = movieRepository.findAll();;
		model.addAttribute("movies", movies);
		return "content/index";
	}
	
	@GetMapping("/selectScr")
	public String selectScrFindMovie(Model model) {
		List<MovieDto> movies = screenService.movieList();
		model.addAttribute("movies" , movies);
		return "content/reservation/selectScr";
	}

	@PostMapping("/selectScr/{id}")
    @ResponseBody
    public List<TheaterDto> selectScrFindTheater(@PathVariable Long id) {
        return screenService.findByMovie(id);
    }
	@PostMapping("/selectScr/{id}/{t_id}")
	@ResponseBody
	public List<DateDto> selectScrFindDate(@PathVariable Long id, @PathVariable Long t_id) {
		return screenService.findByMovieTheater(id, t_id);
	}
	
	@PostMapping("/selectScr/{id}/{t_id}/{date}")
	@ResponseBody
	public Long selectOne(@PathVariable Long id, @PathVariable Long t_id, @PathVariable String date) {
		return screenService.findOneByAll(id, t_id, date);
	}
//	@PostMapping("/selectScr/{id}/{t_id}/{scrDateUnixTimestamp}")
//	@ResponseBody
//	public Long selectOne(@PathVariable Long id, @PathVariable Long t_id,  @PathVariable Long scrDateUnixTimestamp) {
//		LocalDateTime scrDate = Instant.ofEpochSecond(scrDateUnixTimestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
//		return screenService.findOneByAll(id, t_id, scrDate);
//	}
	
}
