<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	border: 1px solid;
}

.divDown {
	text-align: center;
	width: 40.5vw;
	margin-top: 20px;
}

#svg {
	height: 200px
}

#container {
	width: 100vw;
	padding: 0% 0% 0% 30%;
}

.infoLabel {
	display: block;
}

.infoBox {
	margin-left: 50px;
	display: block;
}

.infoCidade {
	width: 20vw;
	display: inline-table;
}
</style>
</head>
<body>
	<div id="container">
		<form action="" method="POST">
			<div class="infoCidade">
				<h2>Cidade 1</h2><br>
				<label class="infoBox">Estado 
					<select name="estado1" onchange="this.submit()">
						<c:forEach var="estado" items="${}">
							<option>${estado}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoBox">Cidade 
					<select name="cidade1">
						<c:forEach var="cidade" items="${}">
							<option>${cidade}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoLabel">População: ${cidade1.getPopulacao()}</label><br>
				<label class="infoLabel">Densidade demográfica: ${cidade1.getDensidade_demo()}</label><br> 
				<label class="infoLabel">Área: ${cidade1.getArea()}km²</label><br> 
				<label class="infoLabel">Perímetro: ${cidade1.getPerimetro()}km</label><br>
			</div>

			<div class="infoCidade">
				<h2>Cidade 2</h2><br> 
				<label class="infoBox">Estado 
					<select name="estado2">
						<c:forEach var="estado" items="${}">
							<option>${estado}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoBox">Cidade 
					<select name="cidade2">
						<c:forEach var="cidade" items="${}">
							<option>${cidade}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoLabel">População: ${cidade2.getPopulacao()}</label><br> 
				<label class="infoLabel">Densidade demográfica: ${cidade2.getDensidade_demo()}</label><br> 
				<label class="infoLabel">Área: ${cidade2.getArea()}km²</label><br> 
				<label class="infoLabel">Perímetro: ${cidade2.getPerimetro()}km</label><br>
			</div><br>
			<div class="divDown">
				<label>Distância Aproximada: ${distancia}km</label><br>
				<div id=svg>SVG</div>
				<!--<br><input type="submit" value="Buscar">-->
			</div>
		</form>
	</div>
</body>
</html>