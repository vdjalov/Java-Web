package app.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.util.FileUtil;

@WebServlet("/")
public class HomeServlet extends HttpServlet{
	
	private static final String HOME_HTML_FILE_PATH = "C:\\Users\\OK\\web-workspace\\skeleton\\src\\main\\webapp\\views\\home.html";
	
	
	private FileUtil fileUtil;
	
	
	@Inject
	public HomeServlet(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String htmlString = this.fileUtil.readFile(HOME_HTML_FILE_PATH);
		PrintWriter pw = resp.getWriter();
		pw.println(htmlString);
		
	}

}
