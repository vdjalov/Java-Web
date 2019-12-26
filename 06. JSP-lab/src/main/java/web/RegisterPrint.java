package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Names;

@WebServlet("/goToRegister")
public class RegisterPrint extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("first-name");
		String middleName = req.getParameter("middle-name");
		String lastName = req.getParameter("last-name");
		
		Names names = new Names(firstName, middleName, lastName);
		
		HttpServletRequest request = req;
		HttpServletResponse response = resp;
		
		req.setAttribute("name", names);
		req.getRequestDispatcher("printNameObject.jsp").forward(request, response);
		
	}
}
