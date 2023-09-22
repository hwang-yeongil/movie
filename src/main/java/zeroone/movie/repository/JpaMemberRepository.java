package zeroone.movie.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import zeroone.movie.domain.Member;


public class JpaMemberRepository implements MemberRepository {
	
	private final EntityManager em;

	public JpaMemberRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name).getResultList();
		return result.stream().findAny();

	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}

//	@Override
//	public Optional<Member> findByUserpw(String userpw) {
//		List<Member> result = em.createQuery("select m from Member m where m.userpw = :userpw", Member.class)
//				.setParameter("userpw", userpw).getResultList();
//		return result.stream().findAny();
//	}
}
