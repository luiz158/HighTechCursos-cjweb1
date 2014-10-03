<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.hightechcursos.entidades.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: Lista dos Usuários</title>
</head>
<body>

	<table border="1">
		<tr bgcolor="#EAEAEA">
			<th>ID</th> <th>Nome</th> <th>Login</th> <th>Senha</th>
		</tr>
	<%
		List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
		
		for (Usuario u: lista) {			
	%>
		<tr>
			<td><%= u.getId()%></td>
			<td><%= u.getNome()%></td>
			<td><%= u.getLogin()%></td>
			<td><%= u.getSenha()%></td>
		</tr>	
	<%
		}
	%>
	</table>
	
</body>
</html>