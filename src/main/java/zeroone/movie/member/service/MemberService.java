package zeroone.movie.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;

//@Service
@Transactional
public class MemberService {

//	@Autowired
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Long join(Member member) {

		validateDuplicateMember(member);
		return memberRepository.save(member).getId();
	}
	
	public void update(Long id, String username, String userpw) {
		Optional<Member> member = memberRepository.findById(id);
		member.ifPresent(selectUser ->{
				selectUser.setName(username);
				selectUser.setUserpw(userpw);
				memberRepository.save(selectUser);
			}
		);
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
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	public boolean login(String username, String userpw) {
		Optional<Member> member = memberRepository.findByName(username);
		if(member.get().getUserpw() == userpw) {
			return true;
		}
		return false;
	}
}
