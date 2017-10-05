<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
         <p>
            Welcome to the Game! You roll 2 dice. If the total is 7, you get $4. If not, you lose $1.
        </p>
        <p>
            <form method="POST" action="playGame">
                <label>Amount of money you wish to bet (in USD): </label>
                <input type="text" name="moneyToBet">
                <input type ="submit" value="Play the game!!!">
            </form>
        </p>       
    </body>
</html>

