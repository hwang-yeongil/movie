package zeroone.movie.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.domain.Seat;
import zeroone.movie.movie.repository.MovieRepository;
import zeroone.movie.movie.repository.ScreenRepository;
import zeroone.movie.movie.repository.SeatRepository;
import zeroone.movie.reservation.domain.Reservation;
import zeroone.movie.reservation.repository.ReservRepository;
import zeroone.movie.reservation.service.ReservService;

@SpringBootTest
@Transactional
public class ReservTest {
	
	@Autowired
	ReservRepository reservRepository;
	private ReservService reservService;
	@Autowired
	ScreenRepository screenRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	SeatRepository seatRepository;
	
	@Test
	public void 추가() throws Exception {
		Member member = memberRepository.findById("tester1").get();
		Screen screen = screenRepository.findById(1L).get();
		Seat seat = seatRepository.findById(10L).get();
		Reservation reserv = Reservation.builder()
				.reservation_pk(3L)
				.reserv_date(LocalDateTime.now())
				.member(member)
				.seat(seat)
				.screen(screen)
				.build();
			
			reservRepository.save(reserv);
		
	}
}
