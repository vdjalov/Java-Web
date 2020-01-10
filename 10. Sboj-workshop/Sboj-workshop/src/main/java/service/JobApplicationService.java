package service;

import java.util.List;

import domain.model.service.JobApplicationServiceModel;

public interface JobApplicationService {

	void saveJobApplication(JobApplicationServiceModel jobApplicationServiceModel);
	List<JobApplicationServiceModel> getAllJobs();
	JobApplicationServiceModel getApplicationById(String id);
	void deleteJobApplicationById(String id);
}
