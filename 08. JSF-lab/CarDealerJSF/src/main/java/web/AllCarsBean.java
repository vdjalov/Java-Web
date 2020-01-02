package web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.models.CarServiceModel;
import service.CarService;

@Named
@RequestScoped
public class AllCarsBean {

	private CarService carService;
//	private List<CarServiceModel> cars;
	
	public AllCarsBean() {};
	
	@Inject
	public AllCarsBean(CarService carService) {
		this.carService = carService;
	}
	
//	
//	@PostConstruct
//	public void init() {
//		this.cars = this.getAllCars();
//	}

	public List<CarServiceModel> getAllCars() {
		return this.carService.getCars();	
	}
//
//	public List<CarServiceModel> getCars() {
//		return cars;
//	}
//
//	public void setCars(List<CarServiceModel> cars) {
//		this.cars = cars;
//	}


	

	
	
	
}
