package app.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import app.context.Context;
import app.domain.model.binding.RegisterUserBindingModel;
import app.domain.model.service.RegisterUserServiceModel;
import app.service.UserService;

@Named(value = "userRegisterBean")
@RequestScoped
public class UserRegisterBean {

	private RegisterUserBindingModel registerUserBindingModel;
	private ModelMapper modelMapper;
	private UserService userService;
	private Context context;
	
	
	public UserRegisterBean() {
	}


	@Inject
	public UserRegisterBean( ModelMapper modelMapper, UserService userService, Context context) {
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.context = context;
	}
	
	
	@PostConstruct
	private void init() {
		this.setRegisterUserBindingModel(new RegisterUserBindingModel());
	}
	
	
	public void registerUser() {
		this.userService.save(this.modelMapper.map(registerUserBindingModel, RegisterUserServiceModel.class));
		this.context.redirect("login");
	}


	public RegisterUserBindingModel getRegisterUserBindingModel() {
		return registerUserBindingModel;
	}


	public void setRegisterUserBindingModel(RegisterUserBindingModel registerUserBindingModel) {
		this.registerUserBindingModel = registerUserBindingModel;
	}
	
	
	
	
	
	
	
}







