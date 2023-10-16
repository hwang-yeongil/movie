package zeroone.movie.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zeroone.movie.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
