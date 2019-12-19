package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.entities.Car;

public final class CarRepository {

	
	 private static List<Car> allCars = new ArrayList<Car>(); 
		
		
		public static void addCar(Car car) {
			allCars.add(car);
		}
		
		
		public static List<Car> getAllCars() {
			return allCars;
		}
}
