package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.context.SessionContext;
import casebook.service.UserService;


@Named("addFriendBean")
@RequestScoped
public class AddFriendBean {

	private SessionContext sessionContext;
	private UserService userService;
	
	
	public AddFriendBean() {
	}


	@Inject
	public AddFriendBean(SessionContext sessionContext, UserService userService) {
		this.sessionContext = sessionContext;
		this.userService = userService;
	}



	public void addFriend() {
		String friendUsername = "";
		String currentLoggedUser = this.sessionContext.getSessionMapAttribute("username");
		int index = 0;
		for(String element:FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().values()) {
			if (index == 0) {
				friendUsername = element;
				break;
			}
		}
		
		this.userService.addFriend(friendUsername, currentLoggedUser);	
		
	}
	
	
}
