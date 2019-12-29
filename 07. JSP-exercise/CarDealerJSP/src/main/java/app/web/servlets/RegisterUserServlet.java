package app.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;
import app.service.HashingService;
import app.service.UserService;

@WebServlet("/users/register")
public class RegisterUserServlet extends HttpServlet {

	private final EntityManager entityManager;
	private final ModelMapper modelMapper;
	private final UserService userService;
	private final HashingService hashingService;
	
	@Inject
	public RegisterUserServlet(EntityManager entityManager, ModelMapper modelMapper,
			UserService userService, HashingService hashingService) {
		this.entityManager = entityManager;
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.hashingService = hashingService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register-user.jsp")
		   .forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPasswrod = req.getParameter("confirmPassword");
		String email = req.getParameter("email");
		
		if(this.userService.validateRegisterPassword(password, confirmPasswrod)) {
			String hashedPassword = this.hashingService.hashPassword(password);
			UserServiceModel userServiceModel = new UserServiceModel();
			userServiceModel.setUsername(username);
			userServiceModel.setPassword(hashedPassword);
			userServiceModel.setEmail(email);
			this.userService.persist(userServiceModel);
			resp.sendRedirect("/users/login");
		} else {
			resp.sendRedirect("/users/register");
		}
	}
}
