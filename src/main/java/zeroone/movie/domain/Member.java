package zeroone.movie.domain;

import java.io.Serializable;

import javax.persistence.Column;
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
	@Column(name = "USERNAME")
	private String name;
	private String userpw;
	private String address;
	private int admin;
	private int secession;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = 0;
	}

	public int getSecession() {
		return secession;
	}

	public void setSecession(int secession) {
		this.secession = 0;
	}


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

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
}
