package web.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bytebuddy.asm.Advice.This;
import service.HttpService;


@WebServlet("/")
public class App extends HttpServlet {
  
	private HttpService httpService;
	
	
	@Inject
	public App(HttpService httpService) {
		this.httpService = httpService;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().println("<h1>I am in! </h1>");
		resp.getWriter().println("<h1>In on the first get! </h1>");
		resp.getWriter().println(this.httpService.getCarForm());
	}
	
	
	protected void doGetttt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("<h1>I am in again! </h1>");
	
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if(req.getMethod().equalsIgnoreCase("GET")) {
////			resp.getWriter().println("<h1>I am in via the service method! </h1>");
//			this.doGettttt(req, resp);
//		}
//
//		
//	}
	
}
