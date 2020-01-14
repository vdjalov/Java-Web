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
		
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(user);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}



	@Override
	public boolean confirmDetails(String username, String password) {
		@SuppressWarnings("unchecked")
		List<User> currentUser = (List<User>) this.entityManager.createNativeQuery("select * from users as u where u.username= :username and u.password= :password", User.class)
									.setParameter("username", username)
									.setParameter("password", password)
									.getResultList();
		
		return currentUser.size() > 0;
	}



	@Override
	public List<User> findAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> allUsers = this.entityManager.createNativeQuery("select * from users", User.class)
												.getResultList();
		return allUsers;
	}



	@Override
	public User findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> user = this.entityManager.createNativeQuery("select * from users as u where u.username= :username", User.class)
											.setParameter("username", username)
											.getResultList();
		
		return user.get(0);
	}



	@Override
	public void updateUserFriends(User friend, String username) {
		
		this.entityManager.getTransaction().begin();
		User user = this.findByUsername(username);
		user.getFriends().add(friend);
		this.entityManager.merge(user);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}



	@Override
	public User findById(String id) {
		@SuppressWarnings("unchecked")
		List<User> user = this.entityManager.createNativeQuery("select * from users as u where u.id= :id", User.class)
											.setParameter("id", id)
											.getResultList();
		
		return user.get(0);
	}

	
	
	
}
