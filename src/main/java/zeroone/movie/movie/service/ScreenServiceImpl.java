package zeroone.movie.movie.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.repository.ScreenRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService{
	
	private final EntityManager em;
	@Autowired
	ScreenRepository screenRepository;
	
	@Override
	public List<Screen> movieList() {
		// TODO Auto-generated method stub
		List<Screen> screens = screenRepository.findAll();
		List<Movie> list = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
		
		for(Screen screen : screens) {
			if(now.isBefore(screen.getScr_date())) {
				
				Movie movie = Movie.builder()
						.movie_pk(screen.getMovie().getMovie_pk())
						.movie_name(screen.getMovie().getMovie_name())
						.build();
				list.add(movie);
			}
		}
		
		return null; 
	}
	@Override
	public List<Screen> findByMovie(Long moive_pk) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Screen> findByMovieTheater(Long moive_pk, Long theater_pk) {
		// TODO Auto-generated method stub
		return null;
	}
}
