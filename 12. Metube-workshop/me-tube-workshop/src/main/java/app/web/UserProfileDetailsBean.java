package app.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import app.context.Context;
import app.domain.model.view.GetUserViewModel;
import app.domain.model.view.ProfileTubesViewModel;
import app.domain.model.view.TubeDetailsViewModel;
import app.service.TubeService;
import app.service.UserService;

@Named(value = "userDetails")
@RequestScoped
public class UserProfileDetailsBean {

	private ModelMapper modelMapper;
	private UserService userService;
	private Context context;
	private TubeService tubeService;
	private String username;
	
	public UserProfileDetailsBean() {
	}

	
	@Inject
	public UserProfileDetailsBean(ModelMapper modelMapper, UserService userRepository, Context context, TubeService tubeService) {
		this.modelMapper = modelMapper;
		this.userService = userRepository;
		this.context = context;
		this.tubeService = tubeService;
	}
	
	@PostConstruct
	private void init() {
		this.username = this.context.getSessionMapObject("username");
	}
	
	
	public List<ProfileTubesViewModel>viewTubes() {
		List<ProfileTubesViewModel> allTubes = this.userService.getUserTubes(this.username).stream()
												   .map(tube -> this.modelMapper.map(tube, ProfileTubesViewModel.class))
												   .collect(Collectors.toList());
		return allTubes;
	}
	
	
	public TubeDetailsViewModel getTube() {
		String youTubeId = this.context.getAttributeMapObject("youTubeId");
		TubeDetailsViewModel tubeDetailsViewModel = this.modelMapper.map(this.tubeService.findTubeByYouTubeId(youTubeId), TubeDetailsViewModel.class);
		return tubeDetailsViewModel;
	}
	
	
	public void logoutUser() {
		this.context.invalidateUserSession();
		this.context.redirect("index");
	}
	
	public GetUserViewModel getUser() {
		return this.modelMapper.map(this.userService.getUserByUsername(this.username), GetUserViewModel.class);
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
}





