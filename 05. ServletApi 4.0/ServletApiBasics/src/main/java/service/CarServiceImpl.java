package service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;

import domain.entities.Car;
import domain.models.service.CarServiceModel;

public class CarServiceImpl implements CarService {

	private ModelMapper modelMapper;
	private EntityManager em;
	
	
	@Inject
	public CarServiceImpl(ModelMapper modelMapper, EntityManager entityManager) {
		this.modelMapper = modelMapper;
		this.em = entityManager;
	}


	@Override
	public void persistCarModel(CarServiceModel carServiceModel) {
		
		Car car =  this.modelMapper.map(carServiceModel, Car.class);
		this.em.getTransaction().begin();
		this.em.persist(car);
		this.em.getTransaction().commit();
		this.em.close();
		
		
	}


}
