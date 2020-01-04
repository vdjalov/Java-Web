package web;

import javax.inject.Named;

@Named("indexBean")
public class IndexBean {
	
	private String message;
	private String logo;
	
	
	public IndexBean() {
		this.setMessage("It works");
	}

	
	public void setLogo() {
		this.logo = "OMG MY LOGO!";
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
