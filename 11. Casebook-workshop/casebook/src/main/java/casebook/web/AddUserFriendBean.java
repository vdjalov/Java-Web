package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.service.UserService;

@Named(value = "addFriendBean")
@RequestScoped
public class AddUserFriendBean {

	private UserService userService;

	
	public AddUserFriendBean() {
	}

	
	@Inject
	public AddUserFriendBean(UserService userService) {
		this.userService = userService;
	}


	public void addFriend(String friendUsername) {
		this.userService.addFriend(friendUsername);
		
		
	}
	
	
	
}
