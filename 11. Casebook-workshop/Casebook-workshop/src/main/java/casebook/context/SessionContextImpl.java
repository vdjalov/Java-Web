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

}
