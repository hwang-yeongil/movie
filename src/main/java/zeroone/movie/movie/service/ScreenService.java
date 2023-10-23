package zeroone.movie.movie.service;

import java.time.LocalDateTime;
import java.util.List;

import zeroone.movie.movie.domain.Screen;

public interface ScreenService {
	// 예매중인 영화 리스트
	List<Screen> movieList();
	// 영화 선택
	List<Screen> findByMovie(Long moive_pk);
	// 선택한 영화가 상영되는 영화관 선택 ( 상영되지 않으면 보여지지 않음)
	List<Screen> findByMovieTheater(Long moive_pk, Long theater_pk);
}
