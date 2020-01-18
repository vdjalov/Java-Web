package casebook.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import casebook.context.Context;
import casebook.domain.model.view.UserViewModel;
import casebook.service.UserService;

@Named(value = "loadUsers")
@RequestScoped
public class LoadHomeUsersBean {

	private UserService userService;
	private ModelMapper modelMapper;
	private Context context;
	
	
	public LoadHomeUsersBean() {
	}


	@Inject
	public LoadHomeUsersBean(UserService userService, ModelMapper modelMapper, Context context) {
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.context = context;
	}
	
	
	
	public List<UserViewModel> loadUsers() {
		String currentUser = context.getSessionMapObject("username");
		List<UserViewModel> allCurrentFriends = this.userService.findAllCurrentFriends(currentUser).stream()
																.map(friend -> this.modelMapper.map(friend, UserViewModel.class))
																.collect(Collectors.toList());
																
																
		List<UserViewModel> allUsers = this.userService.findAllUsers().stream()
													   .filter(user -> {
														   boolean isIn = true;
														   if(user.getUsername().equals(currentUser)) {
															   return false;
														   }
														   
														   for(int i = 0; i < allCurrentFriends.size(); i++) {
															   if(allCurrentFriends.get(i).getId().equals(user.getId())) {
																   isIn = false;
																   break;
															   }
														   }
														return isIn;
													   })
													   .map(el -> this.modelMapper.map(el, UserViewModel.class))
													   .collect(Collectors.toList()); 
		
		return allUsers;
		
		
	}
	
	
	
}
