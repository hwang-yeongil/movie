package zeroone.movie.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyPageDto {
	private String id;
	private String userpw;
	private int secession;
}
