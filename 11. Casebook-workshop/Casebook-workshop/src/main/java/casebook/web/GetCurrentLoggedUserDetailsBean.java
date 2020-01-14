package casebook.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.context.SessionContext;
import casebook.domain.models.view.FriendViewModel;
import casebook.domain.models.view.UserViewModel;
import casebook.service.UserService;

@Named("userDetails")
@RequestScoped
public class GetCurrentLoggedUserDetailsBean {

	private SessionContext sessionContext;
	private UserService userService;
	
	public GetCurrentLoggedUserDetailsBean() {
	}


	@Inject
	public GetCurrentLoggedUserDetailsBean(SessionContext sessionContext, UserService userService) {
		this.sessionContext = sessionContext;
		this.userService = userService;
	} 
	
	
	public String getUsername() {
		return sessionContext.getSessionMapAttribute("username");
	}
	
	
	public UserViewModel getUserDetails() {
		String username = this.getUsername();
		UserViewModel userViewModel = this.userService.getCurrentLoggedUser(username);	
		return userViewModel;
	}
	
	public List<FriendViewModel> findAllFriends() {
		String username = this.sessionContext.getSessionMapAttribute("username");
		List<FriendViewModel> allFrineds = this.userService.findAllFriends(username);
		return allFrineds;
	}
	
	
}
