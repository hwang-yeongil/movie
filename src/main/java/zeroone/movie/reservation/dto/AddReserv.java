package zeroone.movie.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddReserv {

	private Long scr_pk;
	private Long seat_pk;
	private String member_id;
}
