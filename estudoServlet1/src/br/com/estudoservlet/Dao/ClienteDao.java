package br.com.estudoservlet.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estudoservlet.modelo.Cliente;
import br.com.estudoservlet.modelo.Contato;

public class ClienteDao implements IClienteDao {
	
	private Connection conexao;
	
	public ClienteDao() {
		this.conexao = ConnectionFactory.getConnection();
	}


	@Override
	public void salvar(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome_completo,cpf,data_nasc,email,logradouro,bairro,cidade,uf,complemento) VALUES (?,?,?,?,?,?,?,?,?)";
		
			try {
				PreparedStatement stm = this.conexao.prepareStatement(sql);
				stm.setString(1, cliente.getNomeCompleto());
				stm.setString(2, cliente.getCpf());
				stm.setDate(3, new Date(cliente.getDataNasc().getTimeInMillis()));
				stm.setString(4, cliente.getEmail());
				stm.setString(5, cliente.getEndereco().getLogradouro());
				stm.setString(6, cliente.getEndereco().getBairro());
				stm.setString(7, cliente.getEndereco().getCidade());
				stm.setString(8, cliente.getEndereco().getUf());
				stm.setString(9, cliente.getEndereco().getComplemento());				
				
				
				stm.execute();
				this.conexao.close();
	
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir as informacoes no banco"+e.getMessage());
		}		
	}

	@Override
	public void remover(long cod_Cliente) {
		
		String sql = "DELETE FROM cliente  WHERE id = ?";
		
			try {
				PreparedStatement stm = conexao.prepareStatement(sql);
				stm.setLong(1, cod_Cliente);
			
				stm.execute();
				this.conexao.close();
		} catch (SQLException e) {
			throw new  RuntimeException("Erro ao Deletar o Contato"+e.getMessage());
		}
		
		
	}

	@Override
	public void update(Cliente cliente) {
String sql = "UPDATE cliente SET nome_completo = ? WHERE id = ?";
		
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, cliente.getNomeCompleto());
			stm.setLong(2, cliente.getCod_Cliente());
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao Alterar as informacoes."+e.getMessage());
		}
	}
		
	

	@Override
	public List<Cliente> ListarTodos() {
		String sql = "SELECT * FROM cliente";
		
			try {
				PreparedStatement stm = this.conexao.prepareStatement(sql);
				List<Cliente> clientes = new ArrayList<Cliente>();
				ResultSet rs = stm.executeQuery(); 
	
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCod_Cliente(rs.getInt("id"));
				cliente.setNomeCompleto(rs.getString("nome_completo"));
				cliente.setEmail(rs.getString("email"));
				
				clientes.add(cliente);
			}
			
			rs.close();
			stm.close();
			
			return clientes;
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar as informacoes do banco"+e.getMessage());
		}
	}

	@Override
	public Cliente buscarPorNome(String nome) {
		String sql = " SELECT nome_completo FROM cliente WHERE id = ?";
		
			Cliente clienteDb;
			List<Cliente> buscarClientes = new ArrayList<Cliente>();
			try {

			
				PreparedStatement stm = this.conexao.prepareStatement(sql);
				ResultSet rs = stm.executeQuery();

			while (rs.next()) {

				Cliente cl = new Cliente();

				cl.setCod_Cliente(rs.getInt("id"));
				cl.setNomeCompleto(rs.getString("nome_completo"));

				buscarClientes.add(cl);
			}

			rs.close();
			this.conexao.close();

			clienteDb = buscarClientes.get(0);

			return clienteDb;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar as" + "informacoes."
					+ e.getMessage());
		}

	}
	

}
