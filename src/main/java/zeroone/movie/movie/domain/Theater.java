package zeroone.movie.movie.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import groovy.transform.builder.Builder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Theater {
	@Id
	private Long theater_pk;
}
