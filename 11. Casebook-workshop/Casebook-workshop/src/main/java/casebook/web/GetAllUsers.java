package casebook.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import casebook.domain.models.view.UserViewModel;
import casebook.service.UserService;

@Named("getUsers")
@RequestScoped
public class GetAllUsers {

	private UserService userService;

	
	public GetAllUsers() {
	}


	@Inject
	public GetAllUsers(UserService userService) {
		this.userService = userService;
	}
	
	
	
	public List<UserViewModel>getRegisteredUsers() {
		List<UserViewModel> allUsers = this.userService.findAllUsers(); 
		return allUsers;
	}
	
	
	
	
}
