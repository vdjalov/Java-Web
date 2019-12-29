package app.service;

import java.util.List;

import app.domain.models.service.CarServiceModel;
import app.domain.models.service.UserServiceModel;

public interface CarService {

	void persistCar(CarServiceModel carServiceModel, String username);
	List<CarServiceModel> getAllCars();
}
