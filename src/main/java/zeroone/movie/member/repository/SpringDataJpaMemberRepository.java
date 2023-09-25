package zeroone.movie.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.member.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
	
	@Override
	Optional<Member> findByName(String name);
//	@Override
//	Optional<Member> findByUserpw(String userpw);
}
