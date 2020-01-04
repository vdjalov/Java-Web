package web;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("nextBean")
@RequestScoped
public class NextBean {

	
	public NextBean() {};
	
	public void goToNextPage() throws IOException {
		System.out.println();
	
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("next.xhtml");
		
	}
	
}
