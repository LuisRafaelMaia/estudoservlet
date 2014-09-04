package br.com.estudoservlet.Dao;

import java.util.List;

import br.com.estudoservlet.modelo.Contato;

public interface IContatoDao {

	public void salvar (Contato contato);
	
	public void remover (long id);
	
	public void update (Contato contato);
	
	public List<Contato> ListarTodos();
	
	public Contato buscarPorEmail(String email);
	
}
