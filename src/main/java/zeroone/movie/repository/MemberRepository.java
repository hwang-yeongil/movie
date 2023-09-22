package zeroone.movie.repository;

import java.util.List;
import java.util.Optional;

import zeroone.movie.domain.Member;

public interface MemberRepository {

	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
//	Optional<Member> findByUserpw(String userpw);
	List<Member> findAll();
	
}
