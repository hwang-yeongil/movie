package zeroone.movie.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.reservation.domain.Reservation;
import zeroone.movie.reservation.dto.ReservListDto;
import zeroone.movie.reservation.repository.ReservRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservServiceImpl implements ReservService{
	
	@Autowired
	ReservRepository reservRepository;
	
	
	@Override
		public List<ReservListDto> reservGetList() {
			// TODO Auto-generated method stub
			List<Reservation> reservLists = reservRepository.findAll();
			List<ReservListDto> list = new ArrayList<>();
			
			for(Reservation reserv : reservLists ) {
				
				ReservListDto dto = ReservListDto.builder()
						.reservation_pk(reserv.getReservation_pk())
						.reserv_date(reserv.getReserv_date())
						.scr_pk(reserv.getScreen().getScr_pk())
						.seat_pk(reserv.getSeat().getSeat_pk())
						.member_id(reserv.getMember().getId())
						.build();
				
				list.add(dto);
			}
			return list;
		}
}
