package zeroone.movie.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;

//@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

//	@Autowired
	private final MemberRepository memberRepository;
	

//	public MemberService(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}

	public Long join(Member member) {

		validateDuplicateMember(member);
		
		return memberRepository.save(member).getId();
	}

	public void update(Long id, String username, String userpw) {
		Optional<Member> member = memberRepository.findById(id);
		member.ifPresent(selectUser -> {
			selectUser.setUsername(username);
			selectUser.setUserpw(userpw);
			memberRepository.save(selectUser);
		});
	}

	private void validateDuplicateMember(Member member) { // 중복 회원
		memberRepository.findByUsername(member.getUsername()).ifPresent(m -> {
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

	public void delete(Long id) {
		memberRepository.deleteById(id);
	}

	public void deleteId(Long id) {
		Optional<Member> member1 = memberRepository.findById(id);
		member1.ifPresent(t -> {
			t.setSecession(1);
			memberRepository.save(t);
			System.out.println(t.getSecession());
		});
	}

	public boolean login(String username, String userpw) {
		Optional<Member> member = memberRepository.findByUsername(username);
//		값의 존재 여부 확인
		if (member.isPresent()) {
			if (member.get().getUserpw().equals(userpw) && member.get().getSecession() == 0) {
				System.out.println("_____________________________________");
				return true;
			}
		}
		System.out.println("=======================================");
		return false;
	}
	
}
