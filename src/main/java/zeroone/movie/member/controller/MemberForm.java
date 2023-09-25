package zeroone.movie.member.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;

import zeroone.movie.member.domain.Member;

public class MemberForm {
	
	private String name;
	private String userpw;
	private String address;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
