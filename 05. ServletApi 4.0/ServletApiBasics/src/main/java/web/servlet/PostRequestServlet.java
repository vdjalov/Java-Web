package web.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;

import domain.entities.Car;
import domain.models.binding.CarBindingModel;
import service.HttpService;

@WebServlet("/postme")
public class PostRequestServlet extends HttpServlet{
	
	private HttpService httpService;
	
	
	@Inject
	public PostRequestServlet(HttpService httpService) {
		this.httpService = httpService;
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarBindingModel carBindingModel = this.httpService.getCarBindingModel(req);
		this.httpService.formAndPersistCarObject(carBindingModel);
		resp.sendRedirect("/printcars");
	}
}
