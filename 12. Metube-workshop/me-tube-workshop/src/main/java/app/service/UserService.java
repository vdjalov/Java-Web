package app.service;

import java.util.List;

import app.domain.model.service.LoginUserServiceModel;
import app.domain.model.service.ProfileTubesServiceModel;
import app.domain.model.service.RegisterUserServiceModel;
import app.domain.model.view.ProfileTubesViewModel;

public interface UserService {

	void save(RegisterUserServiceModel userServiceModel);
	List<RegisterUserServiceModel> allUsers();
	boolean verifyLogin(LoginUserServiceModel loginUserServiceModel);
	List<ProfileTubesServiceModel> getUserTubes(String username);
	
}
