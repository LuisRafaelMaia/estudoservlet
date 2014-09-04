package br.com.estudoservlet.Dao;

import java.util.List;

import br.com.estudoservlet.modelo.Cliente;

public interface IClienteDao {

	public void salvar(Cliente cliente);

	public void remover(long cod_Cliente);

	public void update(Cliente cliente);

	public List<Cliente> ListarTodos();

	public Cliente buscarPorNome(String nome);

}
