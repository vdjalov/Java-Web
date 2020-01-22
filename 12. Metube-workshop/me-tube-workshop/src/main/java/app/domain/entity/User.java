package app.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
	
	@Column(columnDefinition = "varchar(100) not null unique")
	private String username;
	
	@Column(columnDefinition = "varchar(100) not null")
	private String password;
	
	@Column(columnDefinition = "varchar(100) not null")
	private String email;
	
	
	@OneToMany(targetEntity = Tube.class, mappedBy = "uploader")
	private List<Tube> myTubes;
	
	
	public User() {
		this.myTubes = new ArrayList<Tube>();
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Tube> getMyTubes() {
		return myTubes;
	}


	public void setMyTubes(List<Tube> myTubes) {
		this.myTubes = myTubes;
	}
	
	
	
	
	
	
}
