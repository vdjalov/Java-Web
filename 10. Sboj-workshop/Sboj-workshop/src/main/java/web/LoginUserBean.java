package web;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.UserService;

@Named("loginUser")
@RequestScoped
public class LoginUserBean {

	private String username;
	private String password;
	private UserService userService;
	
	public LoginUserBean() {}
	
	
	@Inject
	public LoginUserBean(UserService userService) {
		this.userService = userService;
	}
	
	
	public void verifyCredentials() throws IOException {
		this.userService.verifyLogin(username, password);
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
