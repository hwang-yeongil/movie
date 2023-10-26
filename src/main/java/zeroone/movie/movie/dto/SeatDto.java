package zeroone.movie.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SeatDto {
//	private Long seat_pk;
	private String seat_name;
	private Long theater_pk;
}
