<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Trabalhando com Expression Language -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: Lista dos Usuários</title>

<script type="text/javascript">
	function confirmarExclusao(id) {
		if (window.confirm("Tem certeza que deseja excluir o registro:" + id)) {
			location.href="usucontroller.do?acao=exc&id=" + id;
		}
	}
</script>

</head>
<body>
	
	<c:import url="includes/menu.jsp"></c:import>
	
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
			<td><a href="javascript:confirmarExclusao(${u.id})"> Excluir </a>
			|
			<a href="usucontroller.do?acao=alt&id=${u.id}"> Alterar </a></td>
		</tr>	
	</c:forEach>
	</table>
	
</body>
</html>