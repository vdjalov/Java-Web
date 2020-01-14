package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.context.SessionContext;
import casebook.domain.models.view.FriendViewModel;
import casebook.service.UserService;

@Named("friendDetails")
@RequestScoped
public class GetCurrentFriendDetailsBean {

	private SessionContext sessionContext;
	private UserService userService;
	
	public GetCurrentFriendDetailsBean() {
	}


	@Inject
	public GetCurrentFriendDetailsBean(SessionContext sessionContext, UserService userService) {
		this.sessionContext = sessionContext;
		this.userService = userService;
	}


	
	
	public FriendViewModel findFriendDetails() {
		String id = this.sessionContext.getParameterMapAttribute("id");
		return this.userService.getFriendById(id);
	}


	
	
}
