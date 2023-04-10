<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Snakes and Ladders</title>
    </head>

    <body>
        <h1>Snakes and Ladders</h1>
        <form action="start" method="post">
            <label for="playerCountInp">Select number of players</label>
            <input id="playerCountInp" type="number" min="2" max="4" name="numberOfPlayers" value="2">
            <input type="submit" value="Play">
        </form>
    </body>
</html>