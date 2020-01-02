package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import domain.entity.Car;
import domain.models.CarServiceModel;
import repository.CarRepository;

public class CarServiceImpl implements CarService {

	
	private CarRepository carRepository;
	private ModelMapper modelMapper;
	
	
	@Inject
	public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
		this.carRepository = carRepository;
		this.modelMapper = modelMapper;
	}

	
	@Override
	public void saveCar(CarServiceModel carServiceModel) {
		this.carRepository.saveCar(this.modelMapper.map(carServiceModel, Car.class));
	}

	
	@Override
	public List<CarServiceModel> getCars() {	
		List<Car> cars = this.carRepository.getAllCars();
		return cars.stream().map(car-> this.modelMapper.map(car, CarServiceModel.class))
						  	.collect(Collectors.toList());
	}

}
