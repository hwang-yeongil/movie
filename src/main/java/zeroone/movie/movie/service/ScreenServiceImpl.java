package zeroone.movie.movie.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.domain.Seat;
import zeroone.movie.movie.dto.DateDto;
import zeroone.movie.movie.dto.MovieDto;
import zeroone.movie.movie.dto.SeatDto;
import zeroone.movie.movie.dto.TheaterDto;
import zeroone.movie.movie.repository.ScreenRepository;
import zeroone.movie.movie.repository.SeatRepository;
import zeroone.movie.reservation.domain.Reservation;
import zeroone.movie.reservation.repository.ReservRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

	private final EntityManager em;
	@Autowired
	SeatRepository seatRepository;
	@Autowired
	ScreenRepository screenRepository;
	@Autowired
	ReservRepository reservRepository;

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
	
	@Override
	public Long findSeat(String seat_name, Long theater_pk, Long scr_pk) {
		// TODO Auto-generated method stub
		Optional<Screen> screen =  screenRepository.findById(scr_pk);
		List<Seat> seats = seatRepository.findAll();
		Long theater = screen.get().getTheater().getTheater_pk();
		Long seat_pk = 0L;
		System.out.println(theater);
		System.out.println("------------------------");
		for(Seat seat : seats) {
			if(theater == theater_pk && theater_pk == seat.getTheater().getTheater_pk()
					&& seat_name.equals(seat.getSeat_name())) {
				System.out.println(seat.getSeat_pk() +" : " + seat.getSeat_name());
				seat_pk = seat.getSeat_pk();
			}
		}
		return seat_pk;
	}
	
	@Override
	public List<String> DisableSeat(Long scr_pk) {
		// TODO Auto-generated method stub
		Optional<Screen> screen = screenRepository.findById(scr_pk);
		List<Reservation> reservations = reservRepository.findAll();
		List<String> list = new ArrayList<>();
		for(Reservation reserv : reservations) {
			
			if(screen.get().getScr_pk() == reserv.getScreen().getScr_pk() && 
					screen.get().getTheater().getTheater_pk() == reserv.getSeat().getTheater().getTheater_pk()){
				System.out.println(reserv.getSeat().getSeat_name());
				list.add(reserv.getSeat().getSeat_name());
			}
		}
		
		return list;
	}
}
