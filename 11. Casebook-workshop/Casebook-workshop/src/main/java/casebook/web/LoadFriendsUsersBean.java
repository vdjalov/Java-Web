package casebook.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import casebook.context.Context;
import casebook.domain.model.view.UserViewModel;
import casebook.service.UserService;

@Named(value = "loadFriendsBean")
@RequestScoped
public class LoadFriendsUsersBean {

	private UserService userService;
	private ModelMapper modelMapper;
	private Context context;
	
	public LoadFriendsUsersBean() {
	}


	@Inject
	public LoadFriendsUsersBean(UserService userService, ModelMapper modelMapper, Context context) {
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.context = context;
	}
	
	
	public List<UserViewModel> findAllFriends() {
		String username = context.getSessionMapObject("username");
		List<UserViewModel> allFriends = this.userService.findAllCurrentFriends(username)
											 .stream()
											 .map(friend -> this.modelMapper.map(friend, UserViewModel.class))
											 .collect(Collectors.toList());
		return allFriends;
		
	}
	
	
	
	
	
}
