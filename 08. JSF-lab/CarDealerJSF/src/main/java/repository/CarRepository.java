package repository;

import java.util.List;

import domain.entity.Car;

public interface CarRepository {

	public void saveCar(Car car);
	public List<Car> getAllCars();
	
	
}
