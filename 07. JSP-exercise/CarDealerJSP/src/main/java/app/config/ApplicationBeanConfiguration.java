package app.config;

import org.modelmapper.ModelMapper;



import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationBeanConfiguration {

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    
    
    @Produces
    public EntityManager entityManager() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarDealer");
		EntityManager em = emf.createEntityManager();	
		return em;
    }
    
    
   
}
