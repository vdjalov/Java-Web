package config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

public class BeanConfiguration {

	
	@Produces
	private ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
	
	
	@Produces
	private EntityManager entityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sboj");
		EntityManager em = emf.createEntityManager();
		
		return em;
		
	}
	
	
	
}
