package service;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;

import context.SessionContext;
import domain.entity.User;
import domain.model.service.UserServiceModel;
import repository.UserRepository;
import utils.UserValidation;
import utils.ValidationUtils;

public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper;
	private UserRepository userRepository;
	private HashingService hashingService;
	private ValidationUtils validationUtils;
	private UserValidation userValidation;
	private SessionContext context;
	private ServletRequest request;
	
	@Inject
	public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, HashingService hashingService, 
			ValidationUtils validationUtils, UserValidation userValidation, SessionContext context, ServletRequest request) {
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
		this.hashingService = hashingService;
		this.validationUtils = validationUtils;
		this.userValidation = userValidation;
		this.context = context;
		this.request = request;
	}

	
	@Override
	public void saveUser(UserServiceModel userServiceModel) throws IOException {
			if(this.userValidation.checkUserPassword(userServiceModel)) {
				String hashedPassword = this.hashingService.hashPassword(userServiceModel.getPassword());
				userServiceModel.setPassword(hashedPassword);
				User user = this.modelMapper.map(userServiceModel, User.class);
					
					if(this.validationUtils.isValid(user) && this.userValidation.checkDuplicateUser(user)) {
					FacesContext.getCurrentInstance().addMessage("register", new FacesMessage("Success")); // Not working check how to properly do it!
						this.userRepository.createUser(user);
						this.context.redirect("login");
					} 
			} 
	}

	
	@Override
	public void verifyLogin(String username, String password) throws IOException {
		 if(this.userRepository.veryfyUserLogin(username, password).size() > 0) {
			 
			HttpServletRequest req = (HttpServletRequest) this.request;
				req.setAttribute("username", username);
				FacesContext.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.put("username", username);
				
			this.context.redirect("home"); 	
		 } else {
			// Display unable to log in message
			 String message = "Username or password are incorrect.";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			
		 }
		 
		 
	}

	





	
	
	
}
