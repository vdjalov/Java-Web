package casebook.service;


import java.util.List;

import casebook.domain.models.service.UserLoginServiceModel;
import casebook.domain.models.service.UserRegisterServiceModel;
import casebook.domain.models.view.UserViewModel;

public interface UserService {

	void registerUser(UserRegisterServiceModel userRegisterServiceModel);

	void verify(UserLoginServiceModel userLoginServiceModel);

	List<UserViewModel> findAllUsers();

	void addFriend(String friendUsername, String currentLoggedUser);

	UserViewModel getCurrentLoggedUser(String username);
	
}
