package zeroone.movie.movie.service;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
	
	private final EntityManager em;
	@Override
	public String findName(Long id) {
		// TODO Auto-generated method stub
		return (String) em.createQuery("select m.movie_name from Movie m where m.movie_id = :id")
			.setParameter("id", id)
			.getSingleResult();
		
				
	}
}
