package zeroone.movie.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.movie.domain.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long>{
}
