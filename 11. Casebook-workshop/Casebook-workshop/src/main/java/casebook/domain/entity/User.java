package casebook.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@NotEmpty
	@Column
	private String username;
	
	@NotEmpty
	@Column
	private String password;
	
	@NotEmpty
	@Column
	private String gender;

	@ManyToMany(targetEntity = User.class)
	@JoinTable(name = "users_friends", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="friend_id", referencedColumnName = "id"))
	private Set<User> friends;
	
	public User() {
		this.friends = new HashSet<>();
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	
	
}
