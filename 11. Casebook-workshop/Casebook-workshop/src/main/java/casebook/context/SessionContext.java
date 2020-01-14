package casebook.context;

public interface SessionContext {

	void redirect(String address);

	String getParameterMapAttribute(String attribute);
	String getSessionMapAttribute(String attribute);

	void logoutUserSession();
}
