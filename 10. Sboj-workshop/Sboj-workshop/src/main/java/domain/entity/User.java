package domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@NotEmpty(message = "Username cannot be empty!")
	@Column(columnDefinition = "varchar(100) unique")
	private String username;
	
	@NotEmpty(message = "Password cannot be empty!")
	@Column(columnDefinition = "varchar(100)", nullable = false)
	private String password;
	
	
	@NotEmpty(message = "Please enter a valid email!")
	@Pattern(regexp = "^[\\w!#$%^&*()_+=]+@[\\w]+\\.[\\w]{2,3}$")
	@Column(columnDefinition = "varchar(100) unique")
	private String email;
	
	
	public User() {
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
	
	
	
	
	
	
}
