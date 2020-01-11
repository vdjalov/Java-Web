package casebook.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import casebook.domain.models.binding.UserLoginBindingModel;
import casebook.domain.models.service.UserLoginServiceModel;
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
	void init() {
		this.userLoginBindingModel = new UserLoginBindingModel();
	}

	
	public void verifylogin() {
		this.userService.verify(this.modelMapper.map(this.userLoginBindingModel, UserLoginServiceModel.class));
	}
	
	

	
	
	
	
}
