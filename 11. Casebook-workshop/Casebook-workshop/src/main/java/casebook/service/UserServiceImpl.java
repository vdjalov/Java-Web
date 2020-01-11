package casebook.service;


import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import casebook.context.SessionContext;
import casebook.domain.entity.User;
import casebook.domain.models.service.UserLoginServiceModel;
import casebook.domain.models.service.UserRegisterServiceModel;
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
				this.sessionContext.redirect("home");
			} else {
				// Do something !
			}
		
	}

}
