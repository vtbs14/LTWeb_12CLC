package week2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns = {"/hello", "/xin-chao"})

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("task week2: ").append(request.getContextPath());
			
		response.setContentType("text/html");
		String ten = request.getParameter("ten");
		String holot = request.getParameter("holot");
		
		PrintWriter printW = response.getWriter();
			
		printW.println("<b>First name</b>: " + ten + "" + "<br/><b>Last name</b>: " + holot);
		printW.println("<h1>Hello</h1>");
		
		PrintWriter out = response.getWriter();
		
		out.println("XinChao" + " " + ten);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
