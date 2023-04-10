<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Game Over!</title>
	</head>
	
	<body>
	<h1><center> Game Over! </center></h1>

	<h2><center>Player ${finished.poll().playerNumber} won</center></h2>
	<c:forEach var="piece" items="${finished}">
		<h3><center>Player ${piece.playerNumber}</center></h3>
	</c:forEach>
	
	<center><form action="gameover" method="post">
		<input type="submit" value="Trykk for å spille igjen" /> 
	</form></center>
	
	</body>
</html>