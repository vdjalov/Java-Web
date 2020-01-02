package service;

import java.util.List;

import domain.models.CarServiceModel;

public interface CarService {

	void saveCar(CarServiceModel carServiceModel);
	List<CarServiceModel> getCars();
	
	
}
