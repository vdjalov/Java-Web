package repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import domain.entity.User;
import service.HashingService;


public class UserRepositoryImpl implements UserRepository {

	private EntityManager em;
	private HashingService hashingService;
	
	@Inject
	public UserRepositoryImpl(EntityManager entityManager, HashingService hashingService) {
		this.em = entityManager;
		this.hashingService = hashingService;
	}


	@Override
	public void createUser(User user) {
		this.em.getTransaction().begin();
		this.em.persist(user);
		this.em.getTransaction().commit();
		this.em.close();
	}


	@Override
	public List<User> findUserByPasswordOrEmail(User user) {
	
		@SuppressWarnings("unchecked")
		List<User> currentUser = (List<User>) this.em.createNativeQuery("select * from users as u where u.username= :username or u.email= :email", User.class)
									.setParameter("username", user.getUsername())
									.setParameter("email", user.getEmail())
									.getResultList();
															
		return currentUser;
	}


	@Override
	public List<User> veryfyUserLogin(String username, String password) {
		
		String currentPassword = this.hashingService.hashPassword(password);
		@SuppressWarnings("unchecked")
		List<User> currentUser = (List<User>) this.em.createNativeQuery("select * from users as u where u.username= :username and u.password= :password", User.class)
									.setParameter("username", username)
									.setParameter("password", currentPassword)
									.getResultList();
		return currentUser;
	}

	
	
}
