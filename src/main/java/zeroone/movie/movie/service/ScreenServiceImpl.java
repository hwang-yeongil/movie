package zeroone.movie.movie.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.dto.MovieDto;
import zeroone.movie.movie.dto.TheaterDto;
import zeroone.movie.movie.repository.ScreenRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService{
	
	private final EntityManager em;
	@Autowired
	ScreenRepository screenRepository;
	
	@Override
	public List<MovieDto> movieList() {
		// TODO Auto-generated method stub
		List<Screen> screens = screenRepository.findAll();
		List<MovieDto> list = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
		
		for(Screen screen : screens) {
			System.out.println(now);
			System.out.println(screen.getScr_date());
			if(now.isBefore(screen.getScr_date())) {
//				dto 만들어보기
				MovieDto dto = MovieDto.builder()
						.movie_pk(screen.getMovie().getMovie_pk())
						.movie_name(screen.getMovie().getMovie_name())
						.build();
				list.add(dto);
			}
		}
		
		return list; 
	}
	@Override
	public List<TheaterDto> findByMovie(Long moive_pk) {
		// TODO Auto-generated method stub
		List<Screen> screens = screenRepository.findAll();
		List<TheaterDto> list = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
		
		for(Screen screen : screens) {
			System.out.println(now);
			System.out.println(screen.getScr_date());
			if(now.isBefore(screen.getScr_date())) {
//				dto 만들어보기
				TheaterDto dto = TheaterDto.builder()
						.theater_pk(moive_pk)
						.build();
				list.add(dto);
			}
		}
		
		
		return list.stream().distinct().collect(Collectors.toList());
	}
	@Override
	public List<Screen> findByMovieTheater(Long moive_pk, Long theater_pk) {
		// TODO Auto-generated method stub
		return null;
	}
}
