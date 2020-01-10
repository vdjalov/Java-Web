package utils;

import javax.inject.Inject;

import domain.entity.User;
import domain.model.service.UserServiceModel;
import repository.UserRepository;

public class UserValidationImpl implements UserValidation {

	private UserRepository userRepository;
	
	
	@Inject
	public UserValidationImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean checkUserPassword(UserServiceModel userServiceModel) {
		
		if(userServiceModel.getPassword().isEmpty() || userServiceModel.getConfirmPassword().isEmpty()) {
			return false;
		}
		
		return userServiceModel.getPassword().equals(userServiceModel.getConfirmPassword());
	}

	@Override
	public boolean checkDuplicateUser(User user) {
		return this.userRepository.findUserByPasswordOrEmail(user).size() == 0;
		
	}

}
