package app.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.domain.models.service.CarServiceModel;
import app.service.CarService;

@WebServlet("/cars/create")
public class CreateCar extends HttpServlet{

	private final CarService carService;
	
	@Inject
	public CreateCar(CarService carService) {
		this.carService = carService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/create-car.jsp")
		   .forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brand = req.getParameter("brand");
		String model = req.getParameter("model");
		Integer year = Integer.valueOf(req.getParameter("year"));
		String engine = req.getParameter("engine");
		String username = req.getSession().getAttribute("username").toString();
		
		CarServiceModel carServiceModel = new CarServiceModel();
		carServiceModel.setBrand(brand);
		carServiceModel.setEngine(engine);
		carServiceModel.setModel(model);
		carServiceModel.setYear(year);
		this.carService.persistCar(carServiceModel, username);
		resp.sendRedirect("/home");
	}
	
}
