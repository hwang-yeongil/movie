package zeroone.movie.member.service;


import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.member.domain.Role;
import zeroone.movie.member.dto.LoginDto;
import zeroone.movie.member.dto.MemberFormDto;
import zeroone.movie.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final EntityManager em;

    public ResponseEntity signup(MemberFormDto formDto) {

        Optional<Member> member = memberRepository.findById(formDto.getId());
        if (member.isEmpty()) {
            Member newMember = Member.builder()
                    .id(formDto.getId())
                    .userpw(formDto.getUserpw())
                    .secession(0)
                    .role(Role.User)
                    .build();

            memberRepository.save(newMember);

            return new ResponseEntity("success", HttpStatus.OK);
        } else {
            return new ResponseEntity("fail", HttpStatus.OK);
        }
    }
    
    public ResponseEntity login(LoginDto loginDto) {
    	Optional<Member> member = memberRepository.findById(loginDto.getId());
        Member memberEntity = member.orElse(null);

        if (member==null){
            return new ResponseEntity("해당 아이디를 가진 회원이 존재하지 않습니다.", HttpStatus.OK);
        }

        if (memberEntity.getUserpw().equals(loginDto.getUserpw())){
        	System.out.println("성공");
            return new ResponseEntity("success", HttpStatus.OK);
        } else {
            return new ResponseEntity("비밀번호가 일치하지 않습니다.", HttpStatus.OK);
        }
    }
    
    public List<Member> findAll() {
    	return em.createQuery("select m from Member m", Member.class).getResultList();
    }

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		em.createQuery("update Member m set m.secession=1 where m.id = :id")
			.setParameter("id", id)
			.executeUpdate();
		em.clear();
	
	}
}