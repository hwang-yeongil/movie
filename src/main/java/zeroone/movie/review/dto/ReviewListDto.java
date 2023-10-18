package zeroone.movie.review.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import zeroone.movie.member.domain.Member;
import zeroone.movie.movie.domain.Movie;

@Getter
@Setter
@Builder
public class ReviewListDto {
	
	private Long review_pk;
	private int rv_star;
	@DateTimeFormat(pattern = "yyyy-MM-dd`T`HH:mm:ss")
	private LocalDateTime rv_date;
	private String rv_title;

	private Member member;
	private Movie movie;
	
}
