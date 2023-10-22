package zeroone.movie.service;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import zeroone.movie.movie.repository.MovieRepository;
import zeroone.movie.reservation.repository.ReservRepository;
import zeroone.movie.reservation.service.ReservService;

@SpringBootTest
@Transactional
public class ReservTest {
	
	@Autowired
	ReservRepository reservRepository;
	private ReservService reservService;
	@Autowired
	MovieRepository movieRepository;
	
	
	@Test
	public void 회원정보찾기() throws Exception {
		
//		reservService.reservGetList();
//		movieRepository.findAll();
		reservRepository.findAll();
		
	}
}
