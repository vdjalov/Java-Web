package casebook.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import casebook.domain.models.binding.UserRegisterBindingModel;
import casebook.domain.models.service.UserRegisterServiceModel;
import casebook.service.UserService;

@Named("createUser")
@RequestScoped
public class CreateUserBean {

	
	private UserRegisterBindingModel userRegisterBindingModel;
	private UserService userService;
	private ModelMapper modelMapper;
	
	public CreateUserBean() {
	}

	
	@Inject
	public CreateUserBean(ModelMapper modelMapper, UserService userService) {
		this.modelMapper = modelMapper;
		this.userService = userService;
	}


	@PostConstruct
	void init() {
		this.userRegisterBindingModel = new UserRegisterBindingModel();
	}
	
	
	public void registerUser() {
		this.userService.registerUser(this.modelMapper.map(this.userRegisterBindingModel, UserRegisterServiceModel.class));
	}
	
	
	
	public UserRegisterBindingModel getUserRegisterBindingModel() {
		return userRegisterBindingModel;
	}

	public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
		this.userRegisterBindingModel = userRegisterBindingModel;
	}
	
	
	
	
	
}
