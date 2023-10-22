package zeroone.movie.reservation.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zeroone.movie.member.domain.Member;
import zeroone.movie.movie.domain.Screen;
import zeroone.movie.movie.domain.Seat;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reservation_pk;
	private LocalDateTime reserv_date;
	
	@ManyToOne@JoinColumn(name="scr_pk", nullable = false)
	private Screen screen;
	@ManyToOne@JoinColumn(name="seat_pk", nullable = false)
	private Seat seat;
	@Enumerated(EnumType.STRING)
	@ManyToOne@JoinColumn(name="member_id", nullable = false)
	private Member member;
}
/*
 * 
CREATE TABLE reservation(
	reservation_pk NUMBER NOT NULL PRIMARY key,
	member_id varchar2(50) NOT NULL,
	scr_pk NUMBER NOT NULL,
	seat_pk NUMBER NOT NULL,
	reserv_date date NOT NULL,
	CONSTRAINT res_seat_fk foreign key(seat_pk) references seat (seat_pk),
	CONSTRAINT res_userid_fk foreign key(userid) references member (id),
	CONSTRAINT res_scr_fk foreign key(scr_pk) references screen (scr_pk)
);
 */
 