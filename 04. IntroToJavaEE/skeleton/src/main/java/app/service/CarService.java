package app.service;

import java.util.List;

import app.domain.models.service.CarServiceModel;

public interface CarService {

	
	void addCar(CarServiceModel carServiceModel);
	List<CarServiceModel> getAllCars();	

	
}
