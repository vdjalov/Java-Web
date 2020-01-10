package web;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import domain.model.service.JobApplicationServiceModel;
import domain.model.view.JobApplicationViewModel;
import service.JobApplicationService;

@Named("homeBean")
@RequestScoped
public class HomeBean {

	private JobApplicationService jobApplicationService;
	private ModelMapper modelMapper;
	
	public HomeBean() {}


	@Inject
	public HomeBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
		this.jobApplicationService = jobApplicationService;
		this.modelMapper = modelMapper;
	} 
	
		
	public List<JobApplicationViewModel> getAllJobs() {
		List<JobApplicationServiceModel> jobs = this.jobApplicationService.getAllJobs();
		
		return jobs.stream().map(JobApplication -> this.modelMapper.map(JobApplication, JobApplicationViewModel.class))
				  .collect(Collectors.toList());
	}
	
	
	
	
}
