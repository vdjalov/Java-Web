package app.service;

import java.util.List;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import app.domain.entity.Tube;
import app.domain.model.service.TubeDetailsServiceModel;
import app.domain.model.service.UploadTubeServiceModel;
import app.domain.model.view.TubeDetailsViewModel;
import app.repository.TubeRepository;
import net.bytebuddy.asm.Advice.This;

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
	public List<UploadTubeServiceModel> allTubes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TubeDetailsServiceModel findTubeByYouTubeId(String youTubeId) {
		TubeDetailsServiceModel tubeDetailsServiceModel = this.modelMapper.map(this.tubeRepository.findByYouTubeId(youTubeId), TubeDetailsServiceModel.class);
		return tubeDetailsServiceModel;
	}

}
