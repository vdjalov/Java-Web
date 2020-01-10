package context;



public interface SessionContext {

	void redirect(String redirect);
	void invalidateUserSession();
	String getSessionMapAttribute(String attribute);
}
