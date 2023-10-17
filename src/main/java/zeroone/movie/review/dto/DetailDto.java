package zeroone.movie.review.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DetailDto {
	private Long review_pk;
	private String rv_title;
	private String rv_content;
	@DateTimeFormat(pattern = "yyyy-MM-dd`T`HH:mm:ss")
	private LocalDateTime rv_date;
	private int rv_star;
//	private String member_id;
}
