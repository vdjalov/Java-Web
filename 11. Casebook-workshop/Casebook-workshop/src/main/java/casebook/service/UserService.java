package casebook.service;

import java.util.List;

import casebook.domain.model.service.UserLoginServiceModel;
import casebook.domain.model.service.UserRegisterServiceModel;
import casebook.domain.model.service.UserServiceModel;
import casebook.domain.model.view.UserViewModel;

public interface UserService {

	void registerUser(UserRegisterServiceModel userServiceModel);

	void verifyUserLogin(UserLoginServiceModel userLoginServiceModel);

	List<UserServiceModel> findAllUsers();

	List<UserServiceModel> findAllCurrentFriends(String username);

	UserServiceModel getUserByUsername();

	void addFriend(String friendUsername);

	void unfriend(String friendUsername);


}
