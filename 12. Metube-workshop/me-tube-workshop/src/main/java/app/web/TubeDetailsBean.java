package app.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import app.domain.model.view.TubesViewModel;
import app.service.TubeService;

@Named(value = "tubeDetails")
@RequestScoped
public class TubeDetailsBean {

	private TubeService tubeService;
	private ModelMapper modelMapper;
	
	public TubeDetailsBean() {
	}


	@Inject
	public TubeDetailsBean(TubeService tubeService, ModelMapper modelMapper) {
		this.tubeService = tubeService;
		this.modelMapper = modelMapper;
	}



	public List<TubesViewModel> loadTubes() {
		return this.tubeService.allTubes()
				   .stream().map(tube -> this.modelMapper.map(tube, TubesViewModel.class))
				   .collect(Collectors.toList());
	}
	
	
}
