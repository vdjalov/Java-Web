package web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import domain.model.binding.JobApplicationBindingModel;
import domain.model.service.JobApplicationServiceModel;
import service.JobApplicationService;

@Named
@RequestScoped
public class AddJobBean {

	private JobApplicationBindingModel jobApplicationBindingModel;
	private JobApplicationService jobApplicationService;
	private ModelMapper modelMapper;
	
	
	public AddJobBean() {}


	@Inject
	public AddJobBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
		this.jobApplicationService = jobApplicationService;
		this.modelMapper = modelMapper;
	}


	@PostConstruct
	private void init() {
		this.jobApplicationBindingModel = new JobApplicationBindingModel();
	}
	

	public void AddJob() {
		JobApplicationServiceModel jasm = this.modelMapper.map(this.jobApplicationBindingModel, JobApplicationServiceModel.class);
		this.jobApplicationService.saveJobApplication(jasm);
	}
	
	
	public JobApplicationBindingModel getJobApplicationBindingModel() {
		return jobApplicationBindingModel;
	}


	public void setJobApplicationBindingModel(JobApplicationBindingModel jobApplicationBindingModel) {
		this.jobApplicationBindingModel = jobApplicationBindingModel;
	}


	
	
	
}
