package zeroone.movie.review.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReviewListDto {
	
	private Long review_pk;
	private String rv_title;
	@DateTimeFormat(pattern = "yyyy-MM-dd`T`HH:mm:ss")
	private LocalDateTime rv_date;
	private int rv_star;
	private String member_id;
}
