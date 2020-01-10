package repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import domain.entity.JobApplication;

public class JobApplicationRepositoryImpl implements JobApplocationRepository {

	private EntityManager entityManager;
	
	
	@Inject
	public JobApplicationRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public void saveJob(JobApplication jobApplication) {
		
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(jobApplication);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}


	@Override
	public List<JobApplication> findAllJobs() {
		@SuppressWarnings("unchecked")
		List<JobApplication> allJobs = entityManager.createNativeQuery("select * from jobapplications", JobApplication.class)
													.getResultList();
		return allJobs;
	}


	@Override
	public JobApplication findById(String id) {
		@SuppressWarnings("unchecked")
		List<JobApplication> job = entityManager.createNativeQuery("select * from jobapplications as ja where ja.id = :id", JobApplication.class)
												    .setParameter("id", id)	
													.getResultList();
		
		return job.get(0);
	}


	@Override
	public void deleteJobById(String id) {
		this.entityManager.getTransaction().begin();
		this.entityManager.createNativeQuery("delete from jobapplications where id = :id")
						  .setParameter("id", id)
						  .executeUpdate();
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

}
