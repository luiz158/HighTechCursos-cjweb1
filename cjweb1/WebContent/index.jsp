<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:: Página Inicial</title>
</head>
<body>

	<c:import url="includes/menu.jsp"></c:import><br />
	
	<p>Ola! Seja bem vindo ${sessionScope.usuLogado.nome}</p>
	
</body>
</html>