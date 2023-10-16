package zeroone.movie.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddReviewFormDto {
	
	private String rv_title;
	private String rv_content;
	private String member_id;
	private Long movie_pk;
	private int rv_star;
}
