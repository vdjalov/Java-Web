package casebook.domain.model.service;

import javax.validation.constraints.NotEmpty;

public class UserLoginServiceModel {

	@NotEmpty(message = "Username should not be empty")
	private String username;
	
	@NotEmpty(message = "Password should not be empty")
	private String password;
	
	@NotEmpty(message = "Confirm-Password should not be empty")
	private String confirmPassword;
	
	@NotEmpty(message = "Gender should not be empty")
	private String gender;
	
	
	public UserLoginServiceModel() {
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


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
