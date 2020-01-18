package casebook.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import casebook.domain.model.binding.UserLoginBindingModel;
import casebook.domain.model.service.UserLoginServiceModel;
import casebook.service.UserService;

@Named("loginUser")
@RequestScoped
public class LoginUserBean {

	
	private UserLoginBindingModel userLoginBindingModel;
	private ModelMapper modelMapper;
	private UserService userService;
	
	public LoginUserBean() {
	}
	
	
	@Inject
	public LoginUserBean(ModelMapper modelMapper, UserService userService) {
		this.modelMapper = modelMapper;
		this.userService = userService;
	}

	
	@PostConstruct
	private void init() {
		this.userLoginBindingModel = new UserLoginBindingModel();
	}

	
	public void verifyLoginCredentials() {
		this.userService.verifyUserLogin(this.modelMapper.map(this.userLoginBindingModel, UserLoginServiceModel.class));
		
		
	}
	
	

	public UserLoginBindingModel getUserLoginBindingModel() {
		return userLoginBindingModel;
	}


	public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
		this.userLoginBindingModel = userLoginBindingModel;
	}

	
	
	
	
	
	
	
	
}





