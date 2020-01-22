package app.config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;

public class Configuration {

	
	@Produces
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	@Produces
	public EntityManager entityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("metube");
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	
}
