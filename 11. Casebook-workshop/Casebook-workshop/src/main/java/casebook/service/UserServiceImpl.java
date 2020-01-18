package casebook.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import casebook.context.Context;
import casebook.domain.entity.User;
import casebook.domain.model.service.UserLoginServiceModel;
import casebook.domain.model.service.UserRegisterServiceModel;
import casebook.domain.model.service.UserServiceModel;
import casebook.repositories.UserRepository;
import casebook.util.MyUtils;

public class UserServiceImpl implements UserService {

	private Context context;
	private ModelMapper modelMapper;
	private UserRepository userRepository;
	private MyUtils utils;
	
	@Inject
	public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, MyUtils utils, Context context) {
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
		this.utils = utils;
		this.context = context;
	}



	@Override
	public void registerUser(UserRegisterServiceModel userServiceModel) {
		if(this.verifyPasswordMatch(userServiceModel)) {
			User user = this.modelMapper.map(userServiceModel, User.class);
			user.setPassword(utils.hashPassword(userServiceModel.getPassword()));
			this.userRepository.save(user);
			this.context.redirect("login");
		} else {
			this.context.redirect("register");
		}
	}

	
	private boolean verifyPasswordMatch(UserRegisterServiceModel userServiceModel) {
		return userServiceModel.getPassword().equals(userServiceModel.getConfirmPassword());
	}



	@Override
	public void verifyUserLogin(UserLoginServiceModel userLoginServiceModel) {
		String username = userLoginServiceModel.getUsername();
		String password = this.utils.hashPassword(userLoginServiceModel.getPassword());
		if(this.userRepository.confirmCredetials(username, password)) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
			this.context.redirect("home");
		} else {
			this.context.redirect("login");
		};
		
	}



	@Override
	public List<UserServiceModel> findAllUsers() {
		return this.userRepository.findAllUsers().stream()
								  .map(user -> this.modelMapper.map(user, UserServiceModel.class))
								  .collect(Collectors.toList());
	}



	@Override
	public List<UserServiceModel> findAllCurrentFriends(String username) {
		
		return this.userRepository.findAllFriends(username).stream()
				  .map(user -> this.modelMapper.map(user, UserServiceModel.class))
				  .collect(Collectors.toList());
	}



	@Override
	public UserServiceModel getUserByUsername() {
		String username = this.context.getAttributeMapObject("user");
		UserServiceModel userServiceModel = this.modelMapper.map(this.userRepository.findUserByUsername(username), UserServiceModel.class);
		return userServiceModel;
	}



	@Override
	public void addFriend(String friendUsername) {
		User friend = this.userRepository.findUserByUsername(friendUsername);
		User user = this.userRepository.findUserByUsername(this.context.getSessionMapObject("username"));
		friend.getAllFriends().add(user);
		user.getAllFriends().add(friend);
		
		this.userRepository.update(user);
		this.userRepository.update(friend);
		this.context.redirect("home");
	}



	@Override
	public void unfriend(String friendUsername) {
		User user = this.userRepository.findUserByUsername(this.context.getSessionMapObject("username"));
		User friend = this.userRepository.findUserByUsername(friendUsername);
		friend.getAllFriends().remove(user);
		user.getAllFriends().remove(friend);
		
		this.userRepository.update(user);
		this.userRepository.update(friend);
		this.context.redirect("friends");
		
	}
	
	
	
	
}







