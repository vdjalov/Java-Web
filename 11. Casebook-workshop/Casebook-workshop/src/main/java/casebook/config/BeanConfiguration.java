package casebook.config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

public class BeanConfiguration {

	@Produces
	public EntityManager entityManger() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("casebook");
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	
	
	@Produces
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
}
