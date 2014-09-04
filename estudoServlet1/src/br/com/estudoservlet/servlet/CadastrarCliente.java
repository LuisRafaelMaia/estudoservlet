package br.com.estudoservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudoservlet.Dao.ClienteDao;
import br.com.estudoservlet.Dao.ContatoDao;
import br.com.estudoservlet.Dao.IClienteDao;
import br.com.estudoservlet.Dao.IContatoDao;
import br.com.estudoservlet.modelo.Cliente;
import br.com.estudoservlet.modelo.Contato;
import br.com.estudoservlet.modelo.Endereço;


@WebServlet("/cadastrarCliente")
public class CadastrarCliente extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String nome_completo,cpf,data_nasc,email,logradouro,bairro,cidade,uf,complemento;
		
		nome_completo = req.getParameter("nomeCompleto");
		cpf = req.getParameter("cpf");
		data_nasc = req.getParameter("data_nasc");
		email = req.getParameter("email");
		logradouro = req.getParameter("logradouro");
		bairro = req.getParameter("bairro");
		cidade = req.getParameter("cidade");
		uf = req.getParameter("uf");
		complemento = req.getParameter("complemento");
		
		
		int diaNasc = Integer.parseInt(data_nasc.substring(0, 2));
		int mesNasc = Integer.parseInt(data_nasc.substring(3, 5)) -1;
		int anoNasc = Integer.parseInt(data_nasc.substring(6, 10));
		
		
		System.out.println(diaNasc);
		
		
		Endereço end = new Endereço();
		end.setLogradouro(logradouro);
		end.setBairro(bairro);
		end.setCidade(cidade);
		end.setUf(uf);
		end.setComplemento(complemento);
		
		
		Cliente cli = new Cliente();
		cli.setNomeCompleto(nome_completo);
		cli.setCpf(cpf);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(anoNasc, mesNasc, diaNasc);
		cli.setDataNasc(dataNascimento);
		cli.setEmail(email);
		cli.setEndereco(end);
		
				
		IClienteDao dao = new ClienteDao();
		
		dao.salvar(cli);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Cadastro realizado com sucesso</h2>");
		out.println("<a href='/listarClientes'>Listar cliente</a>");
		out.println("</body>");
		out.println("</html>");
		
		
	}	
	
	
	
	
	
	




}
