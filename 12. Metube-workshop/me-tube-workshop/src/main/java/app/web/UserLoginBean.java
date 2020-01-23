package app.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import app.context.Context;
import app.domain.model.binding.LoginUserBindingModel;
import app.domain.model.service.LoginUserServiceModel;
import app.service.UserService;

@Named(value = "userLoginBean")
@RequestScoped
public class UserLoginBean {

	private LoginUserBindingModel loginUserBindingModel;
	private UserService userService;
	private Context context;
	private ModelMapper modelMapper;
	
	public UserLoginBean() {
	}


	@Inject
	public UserLoginBean(UserService userService, Context context, ModelMapper modelMapper) {
		this.userService = userService;
		this.context = context;
		this.modelMapper = modelMapper;
	}

	
	@PostConstruct
	private void init() {
		this.loginUserBindingModel = new LoginUserBindingModel();
	}
	
	
	public void loginUser() {
		if(this.userService.verifyLogin(this.modelMapper.map(this.loginUserBindingModel, LoginUserServiceModel.class))) {
			this.context.redirect("home");
		} else {
		
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                        "username or password incorrect", "title"));

			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds()
			.add("loginUser");
//			this.context.redirect("login");
		}
		
	}
	
	
	public LoginUserBindingModel getLoginUserBindingModel() {
		return loginUserBindingModel;
	}


	public void setLoginUserBindingModel(LoginUserBindingModel loginUserBindingModel) {
		this.loginUserBindingModel = loginUserBindingModel;
	}
}
