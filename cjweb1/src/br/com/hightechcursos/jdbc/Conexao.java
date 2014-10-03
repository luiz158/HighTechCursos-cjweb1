package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/bd_cjweb1", "postgres", "congre941");
			System.out.println("Sucesso na conexão!");
		} catch (SQLException e) {
			System.out.println("Erro na conexão! " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado!");
		}
		return conn;
	}
}
