package service;

import java.io.IOException;

import domain.model.service.UserServiceModel;

public interface UserService {

	void saveUser(UserServiceModel userServiceModel) throws IOException;

	void verifyLogin(String username, String password) throws IOException;
	
	
}
