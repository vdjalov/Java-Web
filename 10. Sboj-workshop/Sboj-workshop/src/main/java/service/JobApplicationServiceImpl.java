package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import context.SessionContext;
import domain.entity.JobApplication;
import domain.model.service.JobApplicationServiceModel;
import repository.JobApplocationRepository;
import utils.ValidationUtils;

public class JobApplicationServiceImpl implements JobApplicationService {

	private ModelMapper modelMapper;
	private JobApplocationRepository jar;
	private ValidationUtils validationUtils;
	private SessionContext context;
	
	
	@Inject
	public JobApplicationServiceImpl(ModelMapper modelMapper, JobApplocationRepository jar, ValidationUtils validationUtils, SessionContext context) {
		this.modelMapper = modelMapper;
		this.jar = jar;
		this.validationUtils = validationUtils;
		this.context = context;
	}


	@Override
	public void saveJobApplication(JobApplicationServiceModel jobApplicationServiceModel) {
			JobApplication jobApplication = this.modelMapper.map(jobApplicationServiceModel, JobApplication.class);
		if(this.validationUtils.isValid(jobApplication)) {
			this.jar.saveJob(jobApplication);
			context.redirect("home");
		} else {
			// Do something 
		}
	}


	@Override
	public List<JobApplicationServiceModel> getAllJobs() {
		List<JobApplication> allJobs = this.jar.findAllJobs();
		return allJobs.stream()
					  .map(JobApplication -> this.modelMapper.map(JobApplication, JobApplicationServiceModel.class))
					  .collect(Collectors.toList());
	}


	@Override
	public JobApplicationServiceModel getApplicationById(String id) {
		JobApplicationServiceModel jobApplicationServiceModel = this.modelMapper.map(this.jar.findById(id), JobApplicationServiceModel.class);
		return jobApplicationServiceModel;
	}


	@Override
	public void deleteJobApplicationById(String id) {
		this.jar.deleteJobById(id);
		this.context.redirect("home");
	}





}
