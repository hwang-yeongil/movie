package zeroone.movie.review.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zeroone.movie.member.domain.Member;
import zeroone.movie.movie.domain.Movie;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long review_pk;
//	private Long movie_pk;
//	private String member_id;
	private int rv_star;
	private LocalDateTime rv_date;
	private String rv_title;
	private String rv_content;

	@Enumerated(EnumType.STRING)
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	@ManyToOne
	@JoinColumn(name = "movie_pk", nullable = false)
	private Movie movie;
}
