package br.com.hightechcursos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if ((acao != null) && (acao.equals("cad"))) {
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			
			request.setAttribute("usuario", usuario);
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
		} else if ((acao != null) && (acao.equals("alt"))) {
			String id = request.getParameter("id");
			Usuario usuario = usuarioDAO.buscaPorId(Integer.parseInt(id));
			
			request.setAttribute("usuario", usuario);
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
		} else if ((acao != null) && (acao.equals("exc"))) {
			String id = request.getParameter("id");
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			usuarioDAO.excluir(usuario);
		} else if ((acao != null) && (acao.equals("lis"))) {
			List<Usuario> lista = usuarioDAO.buscarTodos();
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher saida = request.getRequestDispatcher("listaUsuario.jsp");
			saida.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id		= request.getParameter("txtId");
		String nome		= request.getParameter("txtNome");
		String login	= request.getParameter("txtLogin");
		String senha	= request.getParameter("txtSenha");
		
		Usuario usuario = new Usuario();
		if (id != "") {
			usuario.setId(Integer.parseInt(id));
		}
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		PrintWriter saida = response.getWriter();
		saida.print("Salvo com sucesso!");
	}

}
