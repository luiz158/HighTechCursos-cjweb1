package br.com.hightechcursos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet(name = "AutenticadorController", urlPatterns = { "/autController.do" })
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		
		if (sessao != null) {
			sessao.invalidate();
		}
		
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Captura dados da tela
		String login = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");
		
		// Constroi objeto usuário para consulta
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		// Busca no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuRetorno = usuarioDAO.autenticar(usuario);
		if (usuRetorno != null) {
			// Criando sessão
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(3000);
			sessao.setAttribute("usuLogado", usuRetorno);
			
			// Encaminhando ao Index
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}

}
