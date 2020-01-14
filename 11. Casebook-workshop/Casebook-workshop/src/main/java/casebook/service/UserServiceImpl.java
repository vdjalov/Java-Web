package casebook.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import casebook.context.SessionContext;
import casebook.domain.entity.User;
import casebook.domain.models.service.UserLoginServiceModel;
import casebook.domain.models.service.UserRegisterServiceModel;
import casebook.domain.models.view.FriendViewModel;
import casebook.domain.models.view.UserViewModel;
import casebook.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper;
	private UserRepository userRepository;
	private SessionContext sessionContext;
	
	@Inject
	public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, SessionContext sessionContext) {
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
		this.sessionContext = sessionContext;
	}


	public UserServiceImpl() {
	}


	@Override
	public void registerUser(UserRegisterServiceModel userRegisterServiceModel) {
		User user = this.modelMapper.map(userRegisterServiceModel, User.class);
		this.userRepository.save(user);
		
		this.sessionContext.redirect("login");
	}


	@Override
	public void verify(UserLoginServiceModel userLoginServiceModel) {
		String username = userLoginServiceModel.getUsername();
		String password = userLoginServiceModel.getPassword();
			if(userRepository.confirmDetails(username, password)) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
				this.sessionContext.redirect("home");
			} else {
				// Do something !
			}
		
	}


	@Override
	public List<UserViewModel> findAllUsers() {
			List<UserViewModel> alluser = this.userRepository.findAllUsers()
											  .stream()
											  .map(user -> this.modelMapper.map(user, UserViewModel.class))
											  .collect(Collectors.toList());
		return alluser;
	}


	@Override
	public void addFriend(String friendUsername, String currentLoggedInUsername) {
		User friend = this.userRepository.findByUsername(friendUsername);
		this.userRepository.updateUserFriends(friend, currentLoggedInUsername);
		
		this.sessionContext.redirect("friends");
	}


	@Override
	public UserViewModel getCurrentLoggedUser(String username) {
		User user = this.userRepository.findByUsername(username);
		return this.modelMapper.map(user, UserViewModel.class);
	}


	@Override
	public List<FriendViewModel> findAllFriends(String username) {
		List<FriendViewModel> allFriends = this.userRepository.findByUsername(username).getFriends()
												     .stream().map(user -> this.modelMapper.map(user, FriendViewModel.class))
												     .collect(Collectors.toList());
		return allFriends;
	}


	@Override
	public FriendViewModel getFriendById(String id) {
		FriendViewModel friend = this.modelMapper.map(this.userRepository.findById(id), FriendViewModel.class);
		return friend;
	}

}
