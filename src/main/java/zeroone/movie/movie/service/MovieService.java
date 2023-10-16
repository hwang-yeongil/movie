package zeroone.movie.movie.service;

import org.springframework.http.ResponseEntity;

public interface MovieService {
	ResponseEntity findName(Long id);
}
