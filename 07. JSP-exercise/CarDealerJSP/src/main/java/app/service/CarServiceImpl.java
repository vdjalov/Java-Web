package app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import org.modelmapper.ModelMapper;

import app.domain.entities.Car;
import app.domain.entities.User;
import app.domain.models.service.CarServiceModel;


public class CarServiceImpl implements CarService {

	private final EntityManager entityManager;
	private final ModelMapper modelMapper;
	private final UserService userService;
	
	
	@Inject
	public CarServiceImpl(EntityManager entityManager, ModelMapper modelMapper, UserService userService) {
		this.entityManager = entityManager;
		this.modelMapper = modelMapper;
		this.userService = userService;
	}



	@Override
	public void persistCar(CarServiceModel carServiceModel,String username) {
		
		Car car = this.modelMapper.map(carServiceModel, Car.class);
		User user = this.userService.getUser(username);
		car.setUser(user);
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(car);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}



	@Override
	public List<CarServiceModel> getAllCars() {
		
		return (List<CarServiceModel>) this.entityManager.createNativeQuery("select * from cars as c", Car.class)
				   .getResultList()
				   .stream()
				   .map(car -> this.modelMapper.map(car, CarServiceModel.class))
				   .collect(Collectors.toList());
				   
	}
	
	
	

}





