package app.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import app.context.Context;
import app.domain.entity.Tube;
import app.domain.entity.User;
import app.domain.model.service.TubeDetailsServiceModel;

public class TubeRepositoryImpl implements TubeRepository {

	private UserRepository userRepository;
	private EntityManager entityManager; 
	private Context context;
	
	@Inject
	public TubeRepositoryImpl(UserRepository userRepository, EntityManager entityManager, Context context) {
		this.userRepository = userRepository;
		this.entityManager = entityManager;
		this.context = context;
	}



	@Override
	public void save(Tube tube) {
		String username = this.context.getSessionMapObject("username");
		User user = this.userRepository.findByUsername(username);
		tube.setUploader(user);
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(tube);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}



	@Override
	public List<Tube> findAllTubes() {
		@SuppressWarnings("unchecked")
		List<Tube> allTubes = (List<Tube>) this.entityManager.createNativeQuery("select * from tubes", Tube.class);
		return allTubes;
	}



	@Override
	public Tube findByYouTubeId(String youTubeId) {
		@SuppressWarnings("unchecked")
		List<Tube> tubes = this.entityManager.createNativeQuery("select * from tubes as t where t.you_tube_id= :youTubeId", Tube.class)
											 .setParameter("youTubeId", youTubeId)
											 .getResultList();
		
		return tubes.get(0);
	}

	
	
	
	
}
