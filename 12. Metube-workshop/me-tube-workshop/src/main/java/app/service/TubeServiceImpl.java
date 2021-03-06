package app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import app.domain.entity.Tube;
import app.domain.model.service.TubeDetailsServiceModel;
import app.domain.model.service.TubesServiceModel;
import app.domain.model.service.UploadTubeServiceModel;
import app.repository.TubeRepository;

public class TubeServiceImpl implements TubeService {

	private TubeRepository tubeRepository;
	private ModelMapper modelMapper;
	
	
	@Inject
	public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper modelMapper) {
		this.tubeRepository = tubeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void saveTube(UploadTubeServiceModel uploadTubeServiceModel) {
		String tubeId = uploadTubeServiceModel.getYouTubeId().split("[=]+")[1];
		uploadTubeServiceModel.setYouTubeId(tubeId);
		this.tubeRepository.save(this.modelMapper.map(uploadTubeServiceModel, Tube.class));
		
	}

	@Override
	public List<TubesServiceModel> allTubes() {
		  return this.tubeRepository.findAllTubes()
				  		   .stream().map(tube -> this.modelMapper.map(tube, TubesServiceModel.class))
				  		   			.collect(Collectors.toList());
		 
	}

	@Override
	public TubeDetailsServiceModel findTubeByYouTubeId(String youTubeId) {
		TubeDetailsServiceModel tubeDetailsServiceModel = this.modelMapper.map(this.tubeRepository.findByYouTubeId(youTubeId), TubeDetailsServiceModel.class);
		return tubeDetailsServiceModel;
	}

}
