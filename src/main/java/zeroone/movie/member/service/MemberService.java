package zeroone.movie.member.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import zeroone.movie.member.domain.Member;
import zeroone.movie.member.dto.LoginDto;
import zeroone.movie.member.dto.MemberFormDto;
import zeroone.movie.member.dto.MyPageDto;

public interface MemberService {
	ResponseEntity signup(MemberFormDto formDto);
	
	ResponseEntity login(LoginDto loginDto);
	
	List<Member> findAll();
	
	void deleteById(String id);
	
	MyPageDto findId(String id);
	
	ResponseEntity update(String id, LoginDto loginDto);
}
