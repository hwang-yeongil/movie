package zeroone.movie.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.hypersistence.utils.spring.repository.HibernateRepository;
import zeroone.movie.review.domain.Review;

public interface ReviewRepository extends HibernateRepository<Review> ,JpaRepository<Review, Long>{
	
	
}
