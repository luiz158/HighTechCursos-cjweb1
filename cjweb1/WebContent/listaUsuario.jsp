<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Trabalhando com Expression Language -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: Lista dos Usuários</title>
</head>
<body>
	
	<table border="1">
		<tr bgcolor="#EAEAEA">
			<th>ID</th> <th>Nome</th> <th>Login</th> <th>Senha</th> <th>Ação</th>
		</tr>
	
	<c:forEach items="${requestScope.lista}" var="u">
		<tr>
			<td>${u.id}</td>
			<td>${u.nome}</td>
			<td>${u.login}</td>
			<td>${u.senha}</td>
			<td><a href="usucontroller.do?acao=exc&id=${u.id}"> Excluir </a>
			|
			<a href="usucontroller.do?acao=alt&id=${u.id}"> Alterar </a></td>
		</tr>	
	</c:forEach>
	</table>
	
</body>
</html>