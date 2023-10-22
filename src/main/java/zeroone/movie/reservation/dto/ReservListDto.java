package zeroone.movie.reservation.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservListDto {
	private Long reservation_pk;
	@DateTimeFormat(pattern = "yyyy-MM-dd`T`HH:mm:ss")
	private LocalDateTime reserv_date;
	private Long scr_pk;
	private Long seat_pk;
	private String member_id;
}
