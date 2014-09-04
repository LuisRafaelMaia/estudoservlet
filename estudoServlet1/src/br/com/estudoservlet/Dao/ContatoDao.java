package br.com.estudoservlet.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estudoservlet.modelo.Contato;


public class ContatoDao implements IContatoDao {
	
	private Connection conexao;
	
	public ContatoDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public void salvar(Contato contato){
		String sql = "INSERT INTO contato (nome_completo,email,dt_nascimento,dt_cadastro) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement stm = this.conexao.prepareStatement(sql);
			stm.setString(1, contato.getNomeCompleto());
			stm.setString(2, contato.getEmail());
			stm.setDate(3, new Date(contato.getDataNascimento().getTimeInMillis()));
			stm.setDate(4, new Date(contato.getDataCadastro().getTimeInMillis()));
			
			stm.execute();
			this.conexao.close();
	
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir as informacoes no banco"+e.getMessage());
		}
	}

	@Override
	public void remover(long id) {
		
		String sql = "DELETE FROM contato  WHERE id = ?";
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, id);
			
			stm.execute();
			this.conexao.close();
		} catch (SQLException e) {
			throw new  RuntimeException("Erro ao Deletar o Contato"+e.getMessage());
		}
		
		
	}

	@Override
	public List<Contato> ListarTodos() {
		
		String sql = "SELECT * FROM contato";
		
		try {
			PreparedStatement stm = this.conexao.prepareStatement(sql);
			List<Contato> contatos = new ArrayList<Contato>();
			ResultSet rs = stm.executeQuery(); 
	
			while(rs.next()){
				Contato contato = new Contato();
				contato.setIdContato(rs.getLong("id"));
				contato.setNomeCompleto(rs.getString("nome_completo"));
				contato.setEmail(rs.getString("email"));
				
				contatos.add(contato);
			}
			
			rs.close();
			stm.close();
			
			return contatos;
		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar as informacoes do banco"+e.getMessage());
		}
		
	}

	@Override
	public Contato buscarPorEmail(String email) {
		
		String sql = " SELECT email FROM contato WHERE id = ?";
		
		Contato contatoDb;
		List<Contato> buscarContatos = new ArrayList<Contato>();
		try {

			
			PreparedStatement stm = this.conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {

				Contato co = new Contato();

				co.setIdContato(rs.getLong("id"));
				co.setEmail(rs.getString("email"));

				buscarContatos.add(co);
			}

			rs.close();
			this.conexao.close();

			contatoDb = buscarContatos.get(0);

			return contatoDb;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar as" + "informacoes."
					+ e.getMessage());
		}

		
		
		
	}

	@Override
	public void update(Contato contato) {
		
		String sql = "UPDATE contato SET nome_cmpleto = ? WHERE id = ?";
		
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, contato.getNomeCompleto());
			stm.setLong(2, contato.getIdContato());
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao Alterar as informacoes."+e.getMessage());
		}
	}

}
