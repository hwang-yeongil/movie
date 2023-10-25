package zeroone.movie.movie.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DateDto {
	private LocalDate scr_l_date;
	private LocalTime scr_l_time;
	private String scr_date;
}
