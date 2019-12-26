package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.internal.bytebuddy.asm.Advice.This;

@WebServlet("/names")
public class ListServlet extends HttpServlet {

	private List<String> names;
	
	@Override
	public void init() throws ServletException {
		this.names = new ArrayList<String>(Arrays.asList("Gosho", "Misho","Grigor"));
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpServletRequest request = req;
		HttpServletResponse response = resp;
		
		request.setAttribute("names", this.names);
		request.getRequestDispatcher("listNames.jsp").forward(request, response);
		
	}
	
	
	
	
}
