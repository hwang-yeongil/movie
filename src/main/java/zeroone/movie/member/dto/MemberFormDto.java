package zeroone.movie.member.dto;

import lombok.Getter;
import lombok.Setter;
import zeroone.movie.member.domain.Role;

@Getter
@Setter
public class MemberFormDto {

	private String id;
	private String userpw;
	private int secession;
	
}
