package br.com.estudoservlet.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
	
	 public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "postgres", "123");
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao conectar no banco."+e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao carregar o DRIVER de conexao do banco"+e.getMessage());
		}
	
	}
}
