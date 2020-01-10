package repository;

import java.util.List;

import domain.entity.User;

public interface UserRepository {

	void createUser(User user);
	List<User> findUserByPasswordOrEmail(User user);
	List<User> veryfyUserLogin(String username, String password);
	
}
