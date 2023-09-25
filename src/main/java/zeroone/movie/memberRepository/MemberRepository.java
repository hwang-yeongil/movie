package zeroone.movie.memberRepository;

import java.util.List;
import java.util.Optional;

import zeroone.movie.memeberDomain.Member;

public interface MemberRepository {

	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
//	Optional<Member> findByUserpw(String userpw);
	List<Member> findAll();
	
}
