package zeroone.movie.member.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicUpdate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements Serializable{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGeneratorName")
//	@SequenceGenerator(sequenceName = "SequenceName", name = "SequenceGeneratorName", allocationSize = 1)
	
	@Id
	private String id;
	private String userpw;
	private int secession;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	


//	public int getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(int admin) {
//		this.admin = admin;
//	}
//
//	public int getSecession() {
//		return secession;
//	}
//
//	public void setSecession(int secession) {
//		this.secession = secession;
//	}
//
//
//	public Long getId() {
//		return id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	public String getUsername() {
//		return username;
//	}
//	
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getUserpw() {
//		return userpw;
//	}
//
//	public void setUserpw(String userpw) {
//		this.userpw = userpw;
//	}
}
