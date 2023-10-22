package zeroone.movie.movie.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Screen {
	
	@Id
	private Long scr_pk;
	private LocalDateTime scr_date;
	
	@ManyToOne@JoinColumn(name="theater_pk", nullable = false)
	private Theater theater;
	@ManyToOne@JoinColumn(name="movie_pk", nullable = false)
	private Movie movie;
}
/*
	scr_pk NUMBER NOT NULL PRIMARY key,
	theater_pk NUMBER NOT NULL,
	movie_pk NUMBER NOT NULL,
	scr_date date NOT NULL,
	CONSTRAINT scr_theater_fk foreign key(theater_pk) references theater (theater_pk),
	CONSTRAINT scr_movie_fk foreign key(movie_pk) references movie (movie_pk)
*/