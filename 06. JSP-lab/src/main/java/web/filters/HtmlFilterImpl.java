package web.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.DateService;

@WebFilter("/*")
public class HtmlFilterImpl implements Filter{

	private DateService dateService;
	
	
	@Inject
	public HtmlFilterImpl(DateService dateService) {
		this.dateService = dateService;
	}





	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String ip = request.getRemoteAddr();
		String url = request.getPathInfo();
		String currentDateTime = this.dateService.getCurrentDate();
		
		String resultString = String.format("Ip:%s%nURL:%s%nDate:%s%n",
				ip, url, currentDateTime);
		request.setAttribute("user-info", resultString);
		chain.doFilter(request, response);
		
		
	}

}
