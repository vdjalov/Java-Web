package casebook.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import casebook.domain.model.binding.UserRegisterBindingModel;
import casebook.domain.model.service.UserRegisterServiceModel;
import casebook.service.UserService;

@Named(value = "registerUserBean")
@RequestScoped
public class RegisterUserBean {

	private UserRegisterBindingModel userRegisterBindingModel;
	private ModelMapper modelMapper;
	private UserService userService;

	
	
	public RegisterUserBean() {
	}


	@Inject
	public RegisterUserBean(ModelMapper modelMapper, UserService userService) {
		this.modelMapper = modelMapper;
		this.userService = userService;
	}


	@PostConstruct
	private void init() {
		this.userRegisterBindingModel = new UserRegisterBindingModel();
	}

	
	public void registerUser() {
		UserRegisterServiceModel userRegisterServiceModel = this.modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class);
		this.userService.registerUser(userRegisterServiceModel);
	}
	
	

	public UserRegisterBindingModel getUserRegisterBindingModel() {
		return userRegisterBindingModel;
	}


	public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterViewModel) {
		this.userRegisterBindingModel = userRegisterViewModel;
	}
	
	
}
