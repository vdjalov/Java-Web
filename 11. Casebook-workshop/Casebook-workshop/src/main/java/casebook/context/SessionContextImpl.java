package casebook.context;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class SessionContextImpl implements SessionContext {

	@Override
	public void redirect(String redirect) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/views/" + redirect + ".xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getParameterMapAttribute(String attribute) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(attribute);
	}

	@Override
	public String getSessionMapAttribute(String attribute) {
		return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(attribute);
	}

	@Override
	public void logoutUserSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
	}

}
