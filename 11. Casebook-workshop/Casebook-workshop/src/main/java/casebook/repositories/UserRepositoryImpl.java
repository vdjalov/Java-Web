package casebook.repositories;

import java.util.Optional;

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
		int user = this.entityManager.createNamedQuery("select * from users as u where u.username= :username and u.password= :password", User.class)
										  .setParameter("username", username)
										  .setParameter("password", password)
										  .getFirstResult();
		
		return user != 0;
	}

	
	
	
}
