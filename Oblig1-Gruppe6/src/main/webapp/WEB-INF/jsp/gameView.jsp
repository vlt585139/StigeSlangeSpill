<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Snakes And Ladders</title>
    <style>
        td, table {
            border: 1px solid black;
            margin: 0;
        }
        table {
            width: 80%;
            border-collapse: collapse;
        }
        td {
            text-align: center;
            padding: 0;
            margin: 0;
        }
    </style>
</head>

<body>
	<p>It is currently player <c:out value="${queue.peek().playerNumber}"/>'s turn</p>
    <table>
        <c:forEach var="row" items="${board}">
            <tr>
                <c:forEach var="square" items="${row}">
                    <td>
                        ${square.squareNumber}
                        <br>
                        ${square.squareType}
                        <br>
                        ${square.toMove}
                        <br>
                        <p>
                        <c:forEach var="piece" items="${square.pieces}">
                            ${piece.playerNumber} 
                        </c:forEach>
                        </p>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <form action="game" method="post">
        <input type="submit" value="Execute Turn" />
    </form>
</body>

</html>