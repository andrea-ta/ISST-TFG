<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sistema de gestión de TFGs</h1>
	<c:if test="${user != null}">
		<p>
			<c:out value="${user}" />
		</p>
		<div class="datagrid">
			<table>
			<tbody>
				<c:forEach items="${tfgs}" var="tfg">
					<tr>
						<th>Autor</th>
						<td><c:out value="${tfg.autor}" /></td>
					</tr>
					<tr>
						<th>Titulo</th>
						<td><c:out value="${tfg.titulo}" /></td>
					</tr>
					<tr>
						<th>Resumen</th>
						<td><c:out value="${tfg.resumen}" /></td>
					</tr>
					<tr>
						<th>Tutor</th>
						<td><c:out value="${tfg.tutor}" /></td>
					</tr>
					<tr>
						<th>Estado</th>
						<td><c:out value="${tfg.estado}" /></td>
					</tr>
						<c:if test="${profesor != null and tfg.estado == 1}">
							<tr id="ultima">
								<td>Aceptar</td>
								<form action="/AceptarTFG" method="post">
									<input type="hidden" name="autor" value="${tfg.autor}" />
									<td><input type="submit"/></td>
								</form>
							</tr>
						</c:if>
					<tr>
						<td> </td>					
					</tr>
					<tr>
						<td> </td>					
					</tr>
					</c:forEach>
			</tbody>
		</table>
		</div>
		<c:if test="${empty tfgs}">
			<p>
				Puedes pulsar el siguiente enlace para solicitar un TFG 
				<a href="/FormularioNuevoTFG.jsp" />Formulario de solicitud</a>
			</p>
		</c:if>
		<c:if test="${alerta != null}">
			<p>
				<c:out value="${alerta}" />
			</p>
		</c:if>
	</c:if>

	<p><a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></p>
	
</body>
</html>