package br.com.estudoservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudoservlet.Dao.ContatoDao;
import br.com.estudoservlet.Dao.IContatoDao;
import br.com.estudoservlet.modelo.Contato;

@WebServlet("/ListarContatos")
public class ListarContatos extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//System.out.println("Nome"+nome+" E-mail:"+email);
		PrintWriter out = resp.getWriter();
		IContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.ListarTodos();
		
			
		
		out.println("<html>");
		out.println("<head><meta charset='UTF-8'/></head>");
		out.println("<body>");
		out.println("<ol>");
		
		//Imprimir as informações da lista
		for (Contato c : contatos) {
			out.print("<li>"+c.getNomeCompleto()+"<a href='excluir?id=" +c.getIdContato()+"'> Remove</a>"+"</li>");
			
		}
		
		out.println("</ol>");
		out.println("<a href='/listarContatos'>Listar contato</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
	}


