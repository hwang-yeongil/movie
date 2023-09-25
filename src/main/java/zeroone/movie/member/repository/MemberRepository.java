package zeroone.movie.member.repository;

import java.util.List;
import java.util.Optional;

import zeroone.movie.member.domain.Member;

public interface MemberRepository {

	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	void deleteById(Long id);
//	Member update(Long id);
	List<Member> findAll();
}
