package app.repository;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import app.domain.entity.User;

public class UserRepositoryImpl implements UserRepository {

	private EntityManager entityManager;
	
	
	@Inject
	public UserRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public void saveUser(User user) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(user);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	@Override
	public List<User> allUsers() {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) this.entityManager.createNativeQuery("select * from users", User.class);
		return users;
	}


	@Override
	public boolean verifyCredentials(String username, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = this.entityManager.createNativeQuery("select * from users as u where u.username= :username and u.password= :password", User.class)
											 .setParameter("username", username)
											 .setParameter("password", password)
											 .getResultList();
		return users.size() > 0;
	}


	@Override
	public User findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) this.entityManager.createNativeQuery("select * from users as u where u.username= :username", User.class)
								 .setParameter("username", username)
								 .getResultList();
		return users.get(0);
	}

}



