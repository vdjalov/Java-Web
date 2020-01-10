package domain.model.binding;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



@ManagedBean
@RequestScoped
public class UserBindingModel {

	@NotEmpty(message = "Username cannot be empty!")
	private String username;
	
	@NotEmpty(message = "Password cannot be empty!")
	private String password;
	
	@NotEmpty(message = "Repeat password must match password!")
	private String confirmPassword;
	
	@NotEmpty(message = "Please enter a valid email!")
	@Pattern(regexp = "^[\\w!#$%^&*()_+=]+@[\\w]+\\.[\\w]{2,3}$", message = "Please enter a valid email!")
	private String email;
	
	
	public UserBindingModel() {
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	
}
