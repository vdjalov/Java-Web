package repository;

import java.util.List;

import domain.entity.JobApplication;

public interface JobApplocationRepository {

	void saveJob(JobApplication jobApplication);
	List<JobApplication> findAllJobs();
	JobApplication findById(String id);
	void deleteJobById(String id);
	
}
