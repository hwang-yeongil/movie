package zeroone.movie.review.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import zeroone.movie.movie.domain.Movie;

@Getter
@Setter
@Builder
public class UpdateDto {
	private Long review_pk;
	private String rv_title;
	private String rv_content;
}
