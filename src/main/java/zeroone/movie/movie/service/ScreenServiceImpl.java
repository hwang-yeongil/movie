package zeroone.movie.movie.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.dto.DateDto;
import zeroone.movie.movie.dto.MovieDto;
import zeroone.movie.movie.dto.TheaterDto;
import zeroone.movie.movie.repository.ScreenRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

	private final EntityManager em;
	@Autowired
	ScreenRepository screenRepository;

	@Override
	public List<MovieDto> movieList() {
		// TODO Auto-generated method stub
		List<Screen> screens = screenRepository.findAll();
		List<MovieDto> list = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
//		현재 날짜 ~ 2주 후 상영 정보만 표시하게 수정 예정
		for (Screen screen : screens) {
			System.out.println(now);
			System.out.println(screen.getScr_date());
			if (now.isBefore(screen.getScr_date())) {
//				dto 만들어보기
				MovieDto dto = MovieDto.builder().movie_pk(screen.getMovie().getMovie_pk())
						.movie_name(screen.getMovie().getMovie_name()).build();
				list.add(dto);
			}
		}
		List<MovieDto> m_List = DeduplicationUtils.deduplication(list, MovieDto::getMovie_pk);

		return m_List;
	}

	@Override
	public List<TheaterDto> findByMovie(Long movie_pk) {
		// TODO Auto-generated method stub
		List<Screen> screens = screenRepository.findAll();
		List<TheaterDto> list = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();

		for (Screen screen : screens) {
			System.out.println(now);
			System.out.println(screen.getScr_date());
			if (now.isBefore(screen.getScr_date()) && screen.getMovie().getMovie_pk() == movie_pk) {
//				dto 만들어보기
				TheaterDto dto = TheaterDto.builder().theater_pk(screen.getTheater().getTheater_pk()).build();
				System.out.println();
				list.add(dto);
			}
		}

		System.out.println(list.size());
		List<TheaterDto> m_List = DeduplicationUtils.deduplication(list, TheaterDto::getTheater_pk);
		System.out.println(list.size());

		return m_List;
	}

	@Override
	public List<DateDto> findByMovieTheater(Long movie_pk, Long theater_pk) {
		// TODO Auto-generated method stub
		List<Screen> screens = screenRepository.findAll();
		List<DateDto> list = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
		for (Screen screen : screens) {
			if (now.isBefore(screen.getScr_date()) && screen.getMovie().getMovie_pk() == movie_pk
				&& screen.getTheater().getTheater_pk() == theater_pk) {
				
				DateDto dto = DateDto.builder()
					.scr_l_date(screen.getScr_date().toLocalDate())
					.scr_l_time(screen.getScr_date().toLocalTime())
					.scr_date(screen.getScr_date().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")))
					.build();
				
				list.add(dto);
			}
		}
		return list;
	}
	
	@Override
	public Long findOneByAll(Long movie_pk, Long theater_pk, String scr_date) {
		// TODO Auto-generated method stub
		List<Screen> screens = screenRepository.findAll();
		Long scr = 0L;
		LocalDateTime now = LocalDateTime.now();
		for (Screen screen : screens) {
			System.out.println(scr_date);
			System.out.println(screen.getScr_date().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")));
			if (now.isBefore(screen.getScr_date()) && screen.getMovie().getMovie_pk() == movie_pk
				&& screen.getTheater().getTheater_pk() == theater_pk && 
				screen.getScr_date().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")).equals(scr_date)) {
				
				scr = screen.getScr_pk();
			}
		}
		return scr;
	}
}
