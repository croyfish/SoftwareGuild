<%-- 
    Document   : result
    Created on : Oct 4, 2017, 10:09:49 PM
    Author     : jeffc
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <p>
            Result
        </p>
        <p>
            <c:out value="You bet $${moneyToBet}." />
        </p>
        <p>
            <c:out value="You are broke after ${numberOfRollsTaken} rolls." />
        </p>
        <p>
            <c:out value="You should have quit after ${numberOfRollsAtMax} rolls when you had $${maxAmountOfMoney}." />
        </p>
        <p>
            <a href="index.jsp">Play Again!</a>
        </p>          
    </body>
</html>

