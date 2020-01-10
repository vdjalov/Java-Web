package utils;

import domain.entity.User;
import domain.model.service.UserServiceModel;

public interface UserValidation {

	boolean checkUserPassword(UserServiceModel userServiceModel);
	boolean checkDuplicateUser(User user);
	
	
}
