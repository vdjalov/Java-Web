package casebook.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import casebook.enums.Gender;


@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@NotEmpty
	@Column(columnDefinition = "varchar(80) not null unique")
	private String username;
	
	@NotEmpty
	@Column
	private String password;
	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
	@ManyToMany(targetEntity = User.class)
	@JoinTable(name = "users_friends", 
	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="friend_id", referencedColumnName = "id"))
	private List<User> allFriends;
	
	public User() {
		this.allFriends = new ArrayList<User>();
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


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public List<User> getAllFriends() {
		return allFriends;
	}


	public void setAllFriends(List<User> allFriends) {
		this.allFriends = allFriends;
	}
	
	
	
	
	
	
	
	
}
