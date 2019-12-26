package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Names;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("<form method=\"post\" action=\"/goToRegister\">\r\n")
				.append("  <input type=\"text\" name=\"first-name\" value=\"\"> First name<br>\r\n")
				.append("  <input type=\"text\" name=\"middle-name\" value=\"\"> Middle name<br>\r\n")
				.append("  <input type=\"text\" name=\"last-name\" value=\"\"> Last name<br>\r\n")
				.append("  <input type=\"submit\" value=\"Submit\"><br>\r\n")
				.append("</form>");
		
		resp.getWriter().println(sBuilder.toString());
		resp.setContentType("text/html");
	}
	
	
	
}










