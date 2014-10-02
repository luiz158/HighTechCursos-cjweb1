package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;

public class UsuarioDAO
{
	private Connection conn = Conexao.getConnection();
	 
	private void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void alterar(Usuario usuario) {
		String sql = "UPDATE usuarios SET nome=?, login=?, senha=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getId());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void excluir(Usuario usuario) {
		String sql = "DELETE FROM usuarios WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, usuario.getId());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<Usuario> buscarTodos() {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				
				listaUsuario.add(usuario);
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaUsuario;
	}
}
