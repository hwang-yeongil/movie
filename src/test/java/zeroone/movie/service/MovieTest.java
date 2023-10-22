package zeroone.movie.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import zeroone.movie.movie.repository.ScreenRepository;
import zeroone.movie.movie.repository.TheaterRepository;

@SpringBootTest
@Transactional
public class MovieTest {
	
	@Autowired
	TheaterRepository theaterRepository;
	@Autowired
	ScreenRepository screenRepository;
	
	@Test
	public void 회원가입() throws Exception {
		theaterRepository.findAll();
		screenRepository.findAll();
	}
}
