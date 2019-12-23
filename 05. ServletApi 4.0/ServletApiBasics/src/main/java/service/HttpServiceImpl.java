package service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;

import domain.entities.Car;
import domain.models.binding.CarBindingModel;
import domain.models.service.CarServiceModel;

public class HttpServiceImpl implements HttpService {

	private CarService carService;
	private ModelMapper modelMapper;
	
	
	@Inject
	public HttpServiceImpl(CarService carService, ModelMapper modelMapper) {
		this.carService = carService;
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	public CarBindingModel getCarBindingModel(HttpServletRequest req) {
		
		String brand = req.getParameter("brand");
		String model = req.getParameter("model");
		int year = Integer.valueOf(req.getParameter("year"));
		
		CarBindingModel carBindingModel = new CarBindingModel();
		carBindingModel.setBrand(brand);
		carBindingModel.setModel(model);
		carBindingModel.setYear(year);
		
		return carBindingModel;
	}





	@Override
	public void formAndPersistCarObject(CarBindingModel carBindingModel) {
		CarServiceModel carServiceModel = this.modelMapper.map(carBindingModel, CarServiceModel.class);
		this.carService.persistCarModel(carServiceModel);
	}


	@Override
	public String getCarForm() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("<form method=\"post\" action=\"/postme\">\r\n")
				.append("  <input type=\"text\" name=\"brand\" value=\"\" checked> Brand<br>\r\n")
				.append("  <input type=\"text\" name=\"model\" value=\"\"> Model<br>\r\n")
				.append("  <input type=\"text\" name=\"year\" value=\"\"> Year<br>\r\n")
				.append("  <input type=\"submit\" value=\"Submit\"><br>\r\n")
				.append("</form>");
				
		return sBuilder.toString();
	}
	
	
	

}
