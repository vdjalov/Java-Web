package casebook.context;

public interface Context {

	void redirect(String redirect);
	void invalidateUserSession();
	String getAttributeMapObject(String attribute);
	String getSessionMapObject(String attribute);
}
