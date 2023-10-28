package zeroone.movie.reservation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.domain.Seat;
import zeroone.movie.movie.repository.MovieRepository;
import zeroone.movie.movie.repository.ScreenRepository;
import zeroone.movie.movie.repository.SeatRepository;
import zeroone.movie.reservation.domain.Reservation;
import zeroone.movie.reservation.dto.AddReserv;
import zeroone.movie.reservation.repository.ReservRepository;
import zeroone.movie.review.domain.Review;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservServiceImpl implements ReservService {

	@Autowired
	ReservRepository reservRepository;

	private final MemberRepository memberRepository;
	private final ScreenRepository screenRepository;
	private final SeatRepository seatRepository;

	@Override
	public ResponseEntity save(AddReserv formDto) {
		// TODO Auto-generated method stub
		Optional<Member> member = memberRepository.findById(formDto.getMember_id());
		Optional<Screen> screen = screenRepository.findById(formDto.getScr_pk());
		Optional<Seat> seat = seatRepository.findById(formDto.getSeat_pk());

		if (member.isPresent() && screen.isPresent() && seat.isPresent()) {
			Member memberEntity = member.get();
			Screen screenEntity = screen.get();
			Seat seatEntity = seat.get();

			Reservation reserv = Reservation.builder().reserv_date(LocalDateTime.now()).seat(seatEntity)
					.member(memberEntity).screen(screenEntity).build();

			reservRepository.save(reserv);
			return new ResponseEntity("success", HttpStatus.OK);
		} else {
			return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public List<Reservation> findMyReserv(String id) {
		// TODO Auto-generated method stub
		List<Reservation> reservs = reservRepository.findAll();
		List<Reservation> res = new ArrayList<>();

		for (Reservation reserv : reservs) {
			if (reserv.getMember().getId().equals(id)) {
				res.add(reserv);
			}
		}

		return res;
	}
	
	@Override
	public void deleteAll(String id) {
		// TODO Auto-generated method stub
		List<Reservation> reservs = reservRepository.findAll();

		for (Reservation reserv : reservs) {
			if (reserv.getMember().getId().equals(id)) {
				reservRepository.deleteById(reserv.getReservation_pk());
			}
		}
	}
}
