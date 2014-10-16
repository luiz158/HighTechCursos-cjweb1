<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.hightechcursos.entidades.Usuario" %>
<!-- Trabalhando com Scriptlet -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: FormulÃ¡rio de UsuÃ¡rio</title>
</head>
<body>

	<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>
	<form action="usucontroller.do" method="post">
		<label>Id: </label>
		<input type="text" name="txtId" size="10" value="<%=usuario.getId() %>" readonly="readonly" />
		
		<label>Nome: </label>
		<input type="text" name="txtNome" size="30" value="<%=usuario.getNome() %>" /> <br />
		
		<label>Login: </label>
		<input type="text" name="txtLogin" size="20" value="<%=usuario.getLogin() %>" /> <br />
		
		<label>Senha: </label>
		<input type="password" name="txtSenha" size="10" maxlength="6" value="<%=usuario.getSenha() %>" /> <br/>
		
		<br />
		<input type="submit" value="Salvar" size=""/>
	</form>
</body>
</html>