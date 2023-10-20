package zeroone.movie.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateDto {
//	private Long review_pk;
	private String rv_title;
	private String rv_content;
	private int rv_star;

}
