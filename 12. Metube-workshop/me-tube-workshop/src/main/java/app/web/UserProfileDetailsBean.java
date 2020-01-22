package app.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import app.context.Context;
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
	
	
	public UserProfileDetailsBean() {
	}

	
	@Inject
	public UserProfileDetailsBean(ModelMapper modelMapper, UserService userRepository, Context context, TubeService tubeService) {
		this.modelMapper = modelMapper;
		this.userService = userRepository;
		this.context = context;
		this.tubeService = tubeService;
	}
	
	
	public List<ProfileTubesViewModel>viewTubes() {
		String username = this.context.getSessionMapObject("username");
		List<ProfileTubesViewModel> allTubes = this.userService.getUserTubes(username).stream()
												   .map(tube -> this.modelMapper.map(tube, ProfileTubesViewModel.class))
												   .collect(Collectors.toList());
		return allTubes;
	}
	
	
	public TubeDetailsViewModel getTube() {
		String youTubeId = this.context.getAttributeMapObject("youTubeId");
		TubeDetailsViewModel tubeDetailsViewModel = this.modelMapper.map(this.tubeService.findTubeByYouTubeId(youTubeId), TubeDetailsViewModel.class);
		return tubeDetailsViewModel;
	}
	
	
	
}





