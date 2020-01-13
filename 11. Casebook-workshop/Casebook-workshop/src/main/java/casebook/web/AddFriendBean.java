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
//		String friendUsername = sessionContext.getParameterMapAttribute("j_id_j:1:j_id_n:j_id_o");
		String currentLoggedUser = this.sessionContext.getSessionMapAttribute("username");
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap());
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		System.out.println();
		
//		this.userService.addFriend(friendUsername, currentLoggedUser);	
		
	}
	
	
}
