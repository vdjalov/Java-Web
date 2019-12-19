package app.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;

import app.domain.models.view.CarViewModel;
import app.service.CarService;
import app.util.FileUtil;

@WebServlet("/all")
public class AllServlet extends HttpServlet{

	private static final String ALL_HTML_FILE_PATH = "C:\\Users\\OK\\web-workspace\\skeleton\\src\\main\\webapp\\views\\all.html";
	
	private FileUtil fileUtil;
	private CarService carService;
	private ModelMapper modelMapper;
	
	
	@Inject
	public AllServlet(FileUtil fileUtil, CarService carService, ModelMapper modelMapper) {
		this.fileUtil = fileUtil;
		this.carService = carService;
		this.modelMapper = modelMapper;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String allHtml = this.fileUtil.readFile(ALL_HTML_FILE_PATH);
	
		
		List<CarViewModel> carsCarViewModels = 
			this.carService.getAllCars().stream()
										.map(c -> this.modelMapper.map(c, CarViewModel.class))
										.collect(Collectors.toList());
		
		
		StringBuilder sBuilder = new StringBuilder();
		for(CarViewModel carVewModel: carsCarViewModels) {
			sBuilder.append(String.format("<li class = \"d-flex justify-content-around\">" +
							"<div class= \"col-md-4 d-flex flex-column text-center mb-3\">" + 
							"<h2 class= \"text-white text-centre\">Brand: %s </h2>" + 
							"<h4 class= \"text-white text-centre\">Model: %s </h4>" + 
							"<h4 class= \"text-white text-centre\">Year: %s </h4>" +
							"<h4 class= \"text-white text-centre\">Engine: %s </h4></div></li>", 
				carVewModel.getBrand(), carVewModel.getModel(), carVewModel.getYear(), carVewModel.getEngine()));
		}
		
		PrintWriter out = resp.getWriter();
		allHtml = allHtml.replace("{{replace}}", sBuilder.toString());
		out.println(allHtml);
	}
}




