package casebook.repositories;

import java.util.List;

import casebook.domain.entity.User;

public interface UserRepository {

		public void save(User user);

		public boolean confirmDetails(String username, String password);

		public List<User> findAllUsers();

		public User findByUsername(String username);

		public void updateUserFriends(User friend, String username);
}
