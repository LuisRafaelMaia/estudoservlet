package br.com.estudoservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudoservlet.Dao.ContatoDao;
import br.com.estudoservlet.Dao.IContatoDao;
import br.com.estudoservlet.modelo.Contato;


@WebServlet("/contato")
public class CadastrarContato extends HttpServlet {

	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
		
		//Capitura as informações do formulario
		
		
//		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome,email,dataNasc;
		
		nome = req.getParameter("nomeCompleto");
		email = req.getParameter("email");
		dataNasc = req.getParameter("dt_nasc");
		
//		System.out.println(dataNasc.substring(6, 10));
		
		int diaNasc = Integer.parseInt(dataNasc.substring(0, 2));
		int mesNasc = Integer.parseInt(dataNasc.substring(3, 5)) -1;
		int anoNasc = Integer.parseInt(dataNasc.substring(6, 10));
		
		
		Contato contato = new Contato();
		contato.setNomeCompleto(nome);
		contato.setEmail(email);
		
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(anoNasc, mesNasc, diaNasc);
		contato.setDataNascimento(dataNascimento);		
		contato.setDataCadastro(Calendar.getInstance());
		
		IContatoDao dao = new ContatoDao();
		
		dao.salvar(contato);
		
		
		
		
		//System.out.println("Nome"+nome+" E-mail:"+email);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Cadastro realizado com sucesso</h2>");
		out.println("<a href='/listarContatos'>Listar contato</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
	