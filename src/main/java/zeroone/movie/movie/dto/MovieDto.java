package zeroone.movie.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieDto {
	private Long movie_pk;
	private String movie_name;

}
