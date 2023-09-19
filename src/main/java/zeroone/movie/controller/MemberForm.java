package zeroone.movie.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;

import zeroone.movie.domain.Member;

public class MemberForm {
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
