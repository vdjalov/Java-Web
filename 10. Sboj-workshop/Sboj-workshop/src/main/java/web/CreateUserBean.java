package web;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import domain.model.binding.UserBindingModel;
import domain.model.service.UserServiceModel;
import service.UserService;

@Named("createUser")
@RequestScoped
public class CreateUserBean {

	private UserBindingModel userBindingModel;
	private ModelMapper modelMapper;
	private UserService userService;
	
	public CreateUserBean() {}

	
	@Inject
	public CreateUserBean(ModelMapper modelMapper, UserService userService) {
		this.modelMapper = modelMapper;
		this.userService = userService;
	}


	@PostConstruct
	private void init() {
		this.userBindingModel = new UserBindingModel();
	}
	
	
	public void saveUser() throws IOException {
		UserServiceModel userServiceModel = this.modelMapper.map(userBindingModel, UserServiceModel.class);
		this.userService.saveUser(userServiceModel);
	}
	
	
	public UserBindingModel getUserBindingModel() {
		return userBindingModel;
	}

	public void setUserBindingModel(UserBindingModel userBindingModel) {
		this.userBindingModel = userBindingModel;
	}
	
	
	
}
