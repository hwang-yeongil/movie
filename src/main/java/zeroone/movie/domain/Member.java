package zeroone.movie.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Member implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGeneratorName")
	@SequenceGenerator(sequenceName = "SequenceName", name = "SequenceGeneratorName", allocationSize = 1)
	private Long id;
	private String name;
	
//	public Member() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Member(Long id, String name) {
//		this.id = id;
//		this.name = name;
//	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
