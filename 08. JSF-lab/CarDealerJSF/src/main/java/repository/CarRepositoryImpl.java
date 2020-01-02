package repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import domain.entity.Car;

public class CarRepositoryImpl implements CarRepository {

	private EntityManager entityManager;

	
	@Inject
	public CarRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void saveCar(Car car) {
		System.out.println();

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(car);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getAllCars() {
		return   (List<Car>) this.entityManager.createNativeQuery("select * from cars", Car.class)
				.getResultList();
				
	}

}
