package app.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = {"/faces/views/home.xhtml",
						  "/faces/views/upload.xhtml", 
						  "/faces/views/profile.xhtml",
						  "/faces/views/details.xhtml"})
public class UserFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Object username = req.getSession().getAttribute("username");
		
			if(username == null) {
				resp.sendRedirect("/faces/views/index.xhtml");
			} else {
				chain.doFilter(request, response);	
			}
		
	
    }
}
