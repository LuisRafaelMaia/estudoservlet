package br.com.estudoservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudoservlet.Dao.ContatoDao;
import br.com.estudoservlet.Dao.IContatoDao;
import br.com.estudoservlet.modelo.Contato;

@WebServlet("/excluir")
public class ExcluirContato extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		
		IContatoDao dao = new ContatoDao();
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		dao.remover(id);
		
		PrintWriter out = resp.getWriter();		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Cadastro removido com sucesso</h2>");
		out.println("<a href='/listarContatos'>Listar contato</a>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
	
	}

}
