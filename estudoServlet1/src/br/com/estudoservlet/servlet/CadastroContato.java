package br.com.estudoservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroContato  extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		String nome = request.getParameter("nomeCompleto");
	
	writer.println("<html>");
	writer.println("<body>");
	writer.println("<p>"+nome+"</p>");
	writer.println("</body>");
	writer.println("</html>");
	}
		

}
