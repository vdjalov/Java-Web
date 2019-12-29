package app.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;

public class UserServiceImpl implements UserService{

	private final EntityManager entityManager;
	private final ModelMapper modelMapper;
	
	
	@Inject
	public UserServiceImpl(EntityManager entityManager, ModelMapper modelMapper) {
		this.entityManager = entityManager;
		this.modelMapper = modelMapper;
	}

	
	
	@Override
	public boolean validateRegisterPassword(String password, String repeatPassword) {
		return password.equals(repeatPassword);
	}

	@Override
	public void persist(UserServiceModel userServiceModel) {
		User user = this.modelMapper.map(userServiceModel, User.class);
		this.entityManager.getTransaction().begin();;
		this.entityManager.persist(user);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}



	@Override
	public boolean validateLogin(String username, String password) {
		 @SuppressWarnings("unchecked")
		Optional user = this.entityManager.createNativeQuery("select * from users as u where u.username = :username and u.password = :password", User.class)
						  .setParameter("username", username)
						  .setParameter("password", password)
						  .getResultList()
						  .stream() 
						  .map(u -> this.modelMapper.map(u, UserServiceModel.class))
						  .findFirst();
		 
		return user.isPresent();
	}



	@Override
	public User getUser(String username) {
		return (User) this.entityManager.createNativeQuery("select * from users as u where u.username = :username", User.class)
				   .setParameter("username", username)
				   .getSingleResult();
	}

}
