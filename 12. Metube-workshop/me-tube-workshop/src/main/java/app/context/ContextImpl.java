package app.context;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class ContextImpl implements Context{

	
	@Override
	public void redirect(String redirect)  {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
				.redirect("/faces/views/" + redirect + ".xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void invalidateUserSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	
	@Override
	public String getAttributeMapObject(String attribute) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(attribute);
	}
	
	
	@Override
	public String getSessionMapObject(String attribute) {
		return (String) ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute(attribute);
	}
	
}
