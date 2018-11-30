<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
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
	width: 50.5vw;
	margin-top: 20px;
}

#svg {
	height: 200px
}

#container {
	width: 100vw;
	padding: 0% 0% 0% 25%;
}

.infoLabel {
	display: block;
}

.infoBox {
	display: block;
}

.infoCidade {
	width: 25vw;
	display: inline-table;
}
</style>
</head>
<body>
	<div id="container">
		<form action="inicio" method="POST">
			<div class="infoCidade">
				<h2 style="color: red;">Cidade 1</h2><br>
				<label class="infoBox">Estado 
					<select name="estado1" onchange="this.form.submit()" >
						<option>___NENHUM___</option>
						<c:forEach var="estado" items="${estados}">
							<option ${estado1==estado?'selected':''}>${estado}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoBox">Cidade 
					<select name="cidade1" onchange="this.form.submit()" >
						<option>___NENHUM___</option>
						<c:forEach var="cidade" items="${nomeCidades1}">
							<option ${cidadeNome1==cidade?'selected':''}>${cidade}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoLabel">População: ${cidade1.getPopulacao()}</label><br>
				<label class="infoLabel">Densidade demográfica: ${cidade1.getDensidade_demo()} hab/Km²</label><br> 
				<label class="infoLabel">Área: ${cidade1.getArea()} km²</label><br> 
				<label class="infoLabel">Perímetro: ${cidade1.getPerimetro()} km</label><br>
			</div>

			<div class="infoCidade">
				<h2 style="color: blue;">Cidade 2</h2><br> 
				<label class="infoBox">Estado 
					<select name="estado2" onchange="this.form.submit()">
						<option>___NENHUM___</option>
						<c:forEach var="estado" items="${estados}">
							<option ${estado2==estado?'selected':''}>${estado}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoBox">Cidade 
					<select name="cidade2" onchange="this.form.submit()" >
						<option>___NENHUM___</option>
						<c:forEach var="cidade" items="${nomeCidades2}">
							<option ${cidadeNome2==cidade?'selected':''}>${cidade}</option>
						</c:forEach>
					</select>
				</label><br> 
				<label class="infoLabel">População: ${cidade2.getPopulacao()}</label><br> 
				<label class="infoLabel">Densidade demográfica: ${cidade2.getDensidade_demo()} hab/Km²</label><br> 
				<label class="infoLabel">Área: ${cidade2.getArea()} km²</label><br> 
				<label class="infoLabel">Perímetro: ${cidade2.getPerimetro()} km</label><br>
			</div><br>
			<div class="divDown">
				<label>Distância Aproximada: ${distancia} km</label><br>
				<div id=svg>
					<svg viewBox="${viewBox}" width="581" height="200">
						<path d="${cidade1.getSvg()}" stroke="black" stroke-width="0.005" fill="red" fill-opacity=""/>
						<path d="${cidade2.getSvg()}" stroke="black" stroke-width="0.005" fill="blue" fill-opacity=""/>
					</svg>
				</div>
				<!--<br><input type="submit" value="Buscar">-->
			</div>
		</form>
	</div>
</body>
</html>