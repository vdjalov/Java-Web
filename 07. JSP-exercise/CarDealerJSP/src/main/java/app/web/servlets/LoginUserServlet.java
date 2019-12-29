package app.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import app.service.HashingService;
import app.service.UserService;



@WebServlet("/users/login")
public class LoginUserServlet extends HttpServlet {

	private final UserService userService;
	private final HashingService hashingService;
	
	@Inject
	public LoginUserServlet(UserService userService, HashingService hashingService) {
		this.userService = userService;
		this.hashingService = hashingService;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login-user.jsp")
		   .forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String hashedPassword = DigestUtils.sha256Hex(password);
		
			if(this.userService.validateLogin(username, hashedPassword)) {
				
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("/home");
				
			} else {
				resp.sendRedirect("/users/login");
			};
			
		
	}
}
