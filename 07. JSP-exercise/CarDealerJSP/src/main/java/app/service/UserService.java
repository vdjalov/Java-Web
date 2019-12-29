package app.service;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;

public interface UserService {

	boolean validateRegisterPassword(String password, String repeatPassword);

	void persist(UserServiceModel userServiceModel);

	boolean validateLogin(String username, String password);

	User getUser(String username);
}
