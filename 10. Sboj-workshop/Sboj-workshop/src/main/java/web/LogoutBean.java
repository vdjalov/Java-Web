package web;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import context.SessionContext;

@Named("logoutUser")
public class LogoutBean {

	private SessionContext context;
	
	
	@Inject
	public LogoutBean(SessionContext context) {
		this.context = context;
	}



	public void logout() throws IOException {
		this.context.invalidateUserSession();
		this.context.redirect("index");
	}
	
}
