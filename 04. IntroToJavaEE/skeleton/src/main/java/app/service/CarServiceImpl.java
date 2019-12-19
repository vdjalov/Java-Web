package app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import app.domain.entities.Car;
import app.domain.models.service.CarServiceModel;
import app.repository.CarRepository;

public class CarServiceImpl implements CarService {

	private ModelMapper modelMapper;
	
	
	@Inject
	public CarServiceImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public void addCar(CarServiceModel carServiceModel) {
		Car car = this.modelMapper.map(carServiceModel, Car.class);
		CarRepository.addCar(car);
	}

	@Override
	public List<CarServiceModel> getAllCars() {
		return CarRepository.getAllCars()
				.stream()
				.map(c -> this.modelMapper.map(c, CarServiceModel.class))
				.collect(Collectors.toList());				
											
	}
}
