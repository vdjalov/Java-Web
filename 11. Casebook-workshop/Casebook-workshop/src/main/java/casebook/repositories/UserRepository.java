package casebook.repositories;

import casebook.domain.entity.User;

public interface UserRepository {

		public void save(User user);

		public boolean confirmDetails(String username, String password);
}
