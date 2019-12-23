package service;

import javax.servlet.http.HttpServletRequest;

import domain.entities.Car;
import domain.models.binding.CarBindingModel;

public interface HttpService {

	CarBindingModel getCarBindingModel(HttpServletRequest req);
	void formAndPersistCarObject(CarBindingModel carBindingModel);
	String getCarForm();
	
}
