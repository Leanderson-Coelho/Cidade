<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Nome:${cidade.nome }</p>
	<p>Area:${cidade.area }</p>
	<p>População:${cidade.populacao }</p>
	<p>Estado:${cidade.estado }</p>
</body>
</html>