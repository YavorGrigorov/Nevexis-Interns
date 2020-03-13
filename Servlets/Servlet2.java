package demo11;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet2")
public class Servlet2 extends HttpServlet{
	

	private static final long serialVersionUID = -4741295665842234983L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		String str = request.getParameter("color");
		
		
		if(str.equals("")){
			writer.println("<font color=red>String is empty!.</font>");
			writer.flush();
		}else{			
			response.sendRedirect("NewFile.jsp");
		}

	}

}
