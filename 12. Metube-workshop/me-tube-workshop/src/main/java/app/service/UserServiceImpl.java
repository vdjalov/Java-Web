package app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import app.domain.entity.User;
import app.domain.model.service.LoginUserServiceModel;
import app.domain.model.service.ProfileTubesServiceModel;
import app.domain.model.service.RegisterUserServiceModel;
import app.repository.UserRepository;
import app.utils.Utils;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private Utils utils;
	
	
	@Inject
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Utils utils) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.utils = utils;
	}

	@Override
	public void save(RegisterUserServiceModel userServiceModel) {
		User user = this.modelMapper.map(userServiceModel, User.class);
		user.setPassword(this.utils.hashPassword(userServiceModel.getPassword()));
		this.userRepository.saveUser(user);
	}

	@Override
	public List<RegisterUserServiceModel> allUsers() {
		return this.userRepository.allUsers().stream()
						   .map(user-> this.modelMapper.map(user, RegisterUserServiceModel.class))
						   .collect(Collectors.toList());
	}

	@Override
	public boolean verifyLogin(LoginUserServiceModel loginUserServiceModel) {
		String username = loginUserServiceModel.getUsername();
		String password = this.utils.hashPassword(loginUserServiceModel.getPassword());
		
			if(this.userRepository.verifyCredentials(username, password)) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
				return true;
			}
		return false;
		
		
	}

	@Override
	public List<ProfileTubesServiceModel> getUserTubes(String username) {
		return this.userRepository.findByUsername(username).getMyTubes().stream()
							   .map(tube -> this.modelMapper.map(tube, ProfileTubesServiceModel.class))
							   .collect(Collectors.toList());
		
	}
}
