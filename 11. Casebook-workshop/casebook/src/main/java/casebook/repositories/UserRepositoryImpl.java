package casebook.repositories;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import casebook.domain.entity.User;

public class UserRepositoryImpl implements UserRepository {

	private EntityManager entityManager;
	
	
	
	@Inject
	public UserRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User user) {
		this.entityManager.getTransaction().begin();;
		this.entityManager.persist(user);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	
	
	@Override
	public List<User> findAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> allUsers = this.entityManager.createNativeQuery("select * from users", User.class)
												.getResultList();
		return allUsers;
	}

	@Override
	public boolean confirmCredetials(String username, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = this.entityManager.createNativeQuery("select * from users as u where u.username= :username and u.password= :password", User.class)
											.setParameter("username", username)
											.setParameter("password", password)
										    .getResultList();
		
		return users.size() > 0;
	}

	@Override
	public List<User> findAllFriends(String username) {
		@SuppressWarnings("unchecked")
		List<User> allFriends = this.entityManager.createNativeQuery("select * from users as u where u.username= :username", User.class)
											.setParameter("username", username)
										    .getResultList();
		
						
		return allFriends.get(0).getAllFriends();
	}

	@Override
	public User findUserByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> allFriends = this.entityManager.createNativeQuery("select * from users as u where u.username= :username", User.class)
											.setParameter("username", username)
										    .getResultList();
		
						
		return allFriends.get(0);
	}

	@Override
	public void update(User user) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(user);
		this.entityManager.getTransaction().commit();
		
	}

}
