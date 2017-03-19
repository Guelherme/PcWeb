<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pessoa</title>
</head>
<body>
	<form action="cadpessoa" method="post">
		<table>
			<tr>
				<td>CPF</td>
				<td><input type="text" name="cpf" required="required"></td>
			</tr>
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome" required="required"></td>
			</tr>
			<tr>
				<td>Telefone</td>
				<td><input type="text" name="telefone" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="cadastrar"
					value="Cadastrar"></td>
			</tr>
		</table>
		<H2>
			<c:if test="${not empty msgcpf }">
				<c:out value="${msgcpf }" />
			</c:if> <br />
			<c:if test="${not empty msgcad }">
				<c:out value="${msgcad }" />
			</c:if>
		</H2>
	</form>
</body>
</html>