package br.com.hightechcursos.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAutentica
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroAutentica implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutentica() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Casting do HttpSevlet Request
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest.getRequestURI();
		
		// Capturando Sessão
		HttpSession sessao = httpServletRequest.getSession();

		// Está logado?
		if ((sessao.getAttribute("usuLogado") != null) || (url.lastIndexOf("login.html") > -1) || (url.lastIndexOf("autController.do") > -1)) {
			chain.doFilter(request, response);
		} else {
			// Redireciona para login
			((HttpServletResponse) response).sendRedirect("login.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
