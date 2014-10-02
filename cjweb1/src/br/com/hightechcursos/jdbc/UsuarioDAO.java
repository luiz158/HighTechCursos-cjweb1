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
	 
	public void cadastrar(Usuario usuario) {
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
	
	public void alterar(Usuario usuario) {
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
	
	public void excluir(Usuario usuario) {
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
	
	public List<Usuario> buscarTodos() {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			Usuario usuario = new Usuario();			
			while (rs.next()) {				
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
	
	public Usuario buscaPorId(Integer id) {
		String sql = "SELECT * FROM usuarios WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {			
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Erro ao executar consulta! " + e.getMessage());
		}
		
		return usuario;
	}
	
	public List<Usuario> buscarPorNome(String nome) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuarios WHERE nome LIKE ?";
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			
			rs = ps.executeQuery();						
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				
				listaUsuario.add(usuario);
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Erro ao executar consulta! " + e.getMessage());
		}
		
		return listaUsuario;
	}
	
	public Usuario autenticar(Usuario u) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuarios WHERE id=? AND senha=?";
		Usuario usuario = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getSenha());
			
			rs = ps.executeQuery();
			if (rs.next()) {			
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Erro ao executar consulta! " + e.getMessage());
		}
		
		return usuario;
	}
}
