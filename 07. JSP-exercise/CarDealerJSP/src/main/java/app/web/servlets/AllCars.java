package app.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.domain.models.service.CarServiceModel;
import app.domain.models.view.CarViewModel;
import app.service.CarService;
import app.service.MappingService;

@WebServlet("/cars/all")
public class AllCars extends HttpServlet{
	
	private final CarService carService;
	private final MappingService mappingService;
	
	@Inject
	public AllCars(CarService carService, MappingService mappingService) {
		this.carService = carService;
		this.mappingService = mappingService;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CarViewModel> allCarsList = this.mappingService.map(this.carService.getAllCars(), CarViewModel.class);								
																
		req.setAttribute("allCars", allCarsList);
		req.getRequestDispatcher("/allCars.jsp")
		   .forward(req, resp);
		
	}
	
}
