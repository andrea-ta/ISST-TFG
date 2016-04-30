<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${not empty user and empty tfg and empty tfgs}">
<h1>Bienvenido: esta es tu solicitud de Trabajo de Fin de Grado.</h1>
	<form action="/nuevoTFG" method="post" acceptcharset="utf-8">
			<input type="text" name="titulo" id="titulo" maxLength="255"
				size="20" required placeholder="Titulo" />
			<input type="text"
				name="resumen" id="resumen" maxLength="255" required size="20"
				placeholder="resumen" />
			<input type="text" name="tutor" id="tutor"
				maxLength="255" required size="20" placeholder="tutor" />
			<input type="submit" value="Solicitud" />
		</form>
	</c:if>


</body>
</html>