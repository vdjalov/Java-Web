package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import casebook.context.SessionContext;

@Named("logoutBean")
@RequestScoped
public class LogoutBean {

	private SessionContext sessionContext;

	
	public LogoutBean() {
	}


	@Inject
	public LogoutBean(SessionContext sessionContext) {
		this.sessionContext = sessionContext;
	}
	
	
	public void logoutUser() {
		this.sessionContext.logoutUserSession();
		this.sessionContext.redirect("index");
	}
	
	
}
