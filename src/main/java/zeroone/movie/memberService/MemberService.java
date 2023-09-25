package zeroone.movie.memberService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zeroone.movie.memberRepository.MemberRepository;
import zeroone.movie.memeberDomain.Member;

//@Service
@Transactional
public class MemberService {

//	@Autowired
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// 회원 가입
//	public Long join(Member member) {
//
//		validateDuplicateMember(member);
//		memberRepository.save(member);
//		return member.getId();
//	}
	public Long join(Member member) {

		validateDuplicateMember(member);
		return memberRepository.save(member).getId();
	}

	private void validateDuplicateMember(Member member) { // 중복 회원
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");

		});
	}

	// 전체 회원 조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
