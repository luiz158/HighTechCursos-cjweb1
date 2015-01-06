<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: Formulário de Usuário</title>
</head>
<body>

	<c:import url="includes/menu.jsp"></c:import>
	
	<form action="usucontroller.do" method="post">
		<label>Id: </label>
		<input type="text" name="txtId" size="10" value="${requestScope.usuario.id}" readonly="readonly" />
		
		<label>Nome: </label>
		<input type="text" name="txtNome" size="30" value="${requestScope.usuario.nome}" /> <br />
		
		<label>Login: </label>
		<input type="text" name="txtLogin" size="20" value="${requestScope.usuario.login }" /> <br />
		
		<label>Senha: </label>
		<input type="password" name="txtSenha" size="10" maxlength="6" value="${requestScope.usuario.senha}" /> <br/>
		
		<br />
		<input type="submit" value="Salvar" size=""/>
	</form>
</body>
</html>