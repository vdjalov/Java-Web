package app.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import app.context.Context;
import app.domain.model.binding.UploadTubeBindingModel;
import app.domain.model.service.UploadTubeServiceModel;
import app.service.TubeService;

@Named(value = "uploadTube")
@RequestScoped
public class UploadTubeBean {

	private UploadTubeBindingModel uploadTubeBindingModel;
	private TubeService tubeService;
	private ModelMapper modelMapper;
	private Context context;
	
	
	public UploadTubeBean() {
	}
	

	@Inject
	public UploadTubeBean(TubeService tubeService, ModelMapper modelMapper, Context context) {
		this.tubeService = tubeService;
		this.modelMapper = modelMapper;
		this.context = context;
	}


	@PostConstruct
	private void init() {
		this.setUploadTubeBindingModel(new UploadTubeBindingModel());
	}

	
	public void createTube() {
	
		this.tubeService.saveTube(this.modelMapper.map(uploadTubeBindingModel, UploadTubeServiceModel.class));
		this.context.redirect("home");
	}
	
	

	public UploadTubeBindingModel getUploadTubeBindingModel() {
		return uploadTubeBindingModel;
	}


	public void setUploadTubeBindingModel(UploadTubeBindingModel uploadTubeBindingModel) {
		this.uploadTubeBindingModel = uploadTubeBindingModel;
	}
	
	
	
	
	
	
}
