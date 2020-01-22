package app.repository;

import java.util.List;
import java.util.Optional;

import app.domain.entity.User;

public interface UserRepository {

	void saveUser(User user);
	List<User> allUsers();
	boolean verifyCredentials(String username, String password);
	User findByUsername(String username);
	
}
