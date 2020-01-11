package casebook.service;


import casebook.domain.models.service.UserLoginServiceModel;
import casebook.domain.models.service.UserRegisterServiceModel;

public interface UserService {

	void registerUser(UserRegisterServiceModel userRegisterServiceModel);

	void verify(UserLoginServiceModel userLoginServiceModel);
	
}
