package casebook.repositories;

import java.util.List;

import casebook.domain.entity.User;

public interface UserRepository {

	void save(User user);
	List<User> findAllUsers();
	boolean confirmCredetials(String username, String password);
	List<User>findAllFriends(String username);
	User findUserByUsername(String username);
	void update(User user);
}
