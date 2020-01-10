package web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import context.SessionContext;
import domain.model.service.JobApplicationServiceModel;
import domain.model.view.JobApplicationViewModel;
import service.JobApplicationService;

@Named("jobDetailsBean")
@RequestScoped
public class JobDetailsBean {
	
	private JobApplicationService jobApplicationService;
	private ModelMapper modelMapper;
	private SessionContext context;
	private String id;
	public JobDetailsBean() {}


	@Inject
	public JobDetailsBean(JobApplicationService jobApplicationService, ModelMapper modelMapper, SessionContext context) {
		this.jobApplicationService = jobApplicationService;
		this.modelMapper = modelMapper;
		this.context = context;
	}




	public JobApplicationViewModel getJobById() {
		String id = this.context.getSessionMapAttribute("id");
		this.id = id;
		JobApplicationServiceModel jasm = this.jobApplicationService.getApplicationById(id);
		return this.modelMapper.map(jasm, JobApplicationViewModel.class);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
}
