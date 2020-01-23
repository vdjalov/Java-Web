package app.domain.model.service;

import javax.validation.constraints.NotEmpty;

public class LoginUserServiceModel {

	
	@NotEmpty(message = "Username or password incorrect")
	private String username;
	
	@NotEmpty(message = "Username or password incorrect")
	private String password;
	
	public LoginUserServiceModel() {
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
