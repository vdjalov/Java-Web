package app.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;

import app.domain.models.binding.CarBindingModel;
import app.domain.models.service.CarServiceModel;
import app.service.CarService;
import app.util.FileUtil;

@WebServlet("/create")
public class CreateServlet extends HttpServlet{

	
private static final String CREATE_HTML_FILE_PATH = "C:\\Users\\OK\\web-workspace\\skeleton\\src\\main\\webapp\\views\\create.html";
	
	private FileUtil fileUtil;
	private ModelMapper modelMapper;
	private CarService carService;
		
	@Inject
	public CreateServlet(FileUtil fileUtil, ModelMapper modelMapper, CarService carService) {
		this.fileUtil = fileUtil;
		this.modelMapper = modelMapper;
		this.carService = carService;
	}
	
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String htmlString = this.fileUtil.readFile(CREATE_HTML_FILE_PATH);
				PrintWriter pw = resp.getWriter();
				pw.println(htmlString);
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			CarBindingModel carBindingModel = new CarBindingModel();
			String brandString = req.getParameter("brand");
			String modelString = req.getParameter("model");
			Integer yearString = Integer.valueOf(req.getParameter("year"));
			String engineString = req.getParameter("engine");
			
			carBindingModel.setBrand(brandString);
			carBindingModel.setModel(modelString);
			carBindingModel.setYear(yearString);
			carBindingModel.setEngine(engineString);
		
			System.out.println();
			CarServiceModel carServiceModel = this.modelMapper.map(carBindingModel, CarServiceModel.class);
			this.carService.addCar(carServiceModel);
			
			resp.sendRedirect("/all");
		}
}






