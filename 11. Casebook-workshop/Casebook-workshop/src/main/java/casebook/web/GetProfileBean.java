package casebook.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import casebook.domain.model.view.UserViewModel;
import casebook.service.UserService;

@Named(value = "getProfileDetails")
@RequestScoped
public class GetProfileBean {

	
	private UserService userService;
	private ModelMapper modelMapper;
	
	
	public GetProfileBean() {
	}


	@Inject
	public GetProfileBean(UserService userService, ModelMapper modelMapper) {
		this.userService = userService;
		this.modelMapper = modelMapper;
	}


	public UserViewModel getProfileDetailsByUsername() {
		UserViewModel userViewModel = this.modelMapper.map(this.userService.getUserByUsername(), UserViewModel.class);
		return userViewModel;
	}
	
}
