package web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import context.SessionContext;
import service.JobApplicationService;

@Named
@RequestScoped
public class DeleteJobBean {

	private SessionContext sessionContext;
	private JobApplicationService jobApplicationService;
	
	public DeleteJobBean() {}


	@Inject
	public DeleteJobBean(SessionContext sessionContext, JobApplicationService jobApplicationService) {
		this.sessionContext = sessionContext;
		this.jobApplicationService = jobApplicationService;
	}


	public void deleteJob() {
		String id = this.sessionContext.getSessionMapAttribute("j_id_m:j_id_w");
		this.jobApplicationService.deleteJobApplicationById(id);
	}
	
	
	
}
