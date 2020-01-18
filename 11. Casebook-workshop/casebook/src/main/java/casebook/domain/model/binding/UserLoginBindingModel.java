package casebook.domain.model.binding;

import javax.validation.constraints.NotEmpty;

public class UserLoginBindingModel {

	
	private Integer id;
	
	@NotEmpty(message = "username should not be empty")
	private String username;
	
	@NotEmpty(message = "password should not be empty")
	private String password;
	
	
	public UserLoginBindingModel() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
	
	
	
	
	
}
