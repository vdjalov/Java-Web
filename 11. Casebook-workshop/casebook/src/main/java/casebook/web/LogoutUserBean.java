package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.context.Context;

@Named(value = "logoutUser")
@RequestScoped
public class LogoutUserBean {

	private Context context;
	
	
	public LogoutUserBean() {
	}


	@Inject
	public LogoutUserBean(Context context) {
		this.context = context;
	}


	public void logoutUser() {
		this.context.invalidateUserSession();
		this.context.redirect("index");
	}
	
	
}
