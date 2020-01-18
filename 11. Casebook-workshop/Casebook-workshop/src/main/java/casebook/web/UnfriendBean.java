package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.service.UserService;

@Named(value = "unfriendBean")
@RequestScoped
public class UnfriendBean {

	private UserService userService;
	
	
	public UnfriendBean() {
	}


	@Inject
	public UnfriendBean(UserService userService) {
		this.userService = userService;
	}


	public void unfriend(String friendUsername) {
		this.userService.unfriend(friendUsername);
		
	}
	
	
}
