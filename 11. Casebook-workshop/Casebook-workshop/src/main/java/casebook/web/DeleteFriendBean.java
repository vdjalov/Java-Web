package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.context.SessionContext;
import casebook.service.UserService;

@Named(value = "deleteBean")
@RequestScoped
public class DeleteFriendBean {

	private SessionContext sessionContext;
	private UserService userService;
	
	
	public DeleteFriendBean() {
	}


	@Inject
	public DeleteFriendBean(SessionContext sessionContext, UserService userService) {
		this.sessionContext = sessionContext;
		this.userService = userService;
	}



	public void deleteFriend() {
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap());
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		System.out.println();
		System.out.println();
		this.sessionContext.redirect("index");
	}
	
	
	
	
	
}
