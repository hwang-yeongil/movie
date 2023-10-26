package zeroone.movie.movie.service;

import java.time.LocalDateTime;
import java.util.List;

import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.dto.DateDto;
import zeroone.movie.movie.dto.MovieDto;
import zeroone.movie.movie.dto.TheaterDto;


public interface ScreenService {
	// 예매중인 영화 리스트
	List<MovieDto> movieList();
	// 영화 선택
	List<TheaterDto> findByMovie(Long moive_pk);
	// 선택한 영화가 상영되는 영화관 선택 ( 상영되지 않으면 보여지지 않음)
	List<DateDto> findByMovieTheater(Long moive_pk, Long theater_pk);
	
	Long findOneByAll(Long movie_pk, Long theater_pk, String scr_date);
	
	Long findSeat(String seat_name, Long theater_pk, Long scr_pk);
}
