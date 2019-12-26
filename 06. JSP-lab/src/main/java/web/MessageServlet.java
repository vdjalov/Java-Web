package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/")
public class MessageServlet extends HttpServlet {

	private String message;

	
	@Override
	public void init() throws ServletException {
		this.message = "I am in!";
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpServletRequest request = req;
		HttpServletResponse response = resp;
		
		req.setAttribute("message", this.message);
		req.getRequestDispatcher("home.jsp").forward(request, response);	
	}
	
	
	
}
