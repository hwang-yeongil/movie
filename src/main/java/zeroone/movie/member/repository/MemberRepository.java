package zeroone.movie.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	Member save(Member member);
	List<Member> findAll();
	Optional<Member> findById(String id);
}
