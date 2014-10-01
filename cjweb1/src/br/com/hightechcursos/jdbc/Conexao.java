package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/", "postgres", "congre941");
			System.out.println("Sucesso na conexão!");
		} catch (SQLException e) {
			System.out.println("Erro na conexão! " + e.getMessage());
		}
		return conn;
	}
}
