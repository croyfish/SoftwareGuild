<%-- 
    Document   : result
    Created on : Oct 4, 2017, 10:18:14 PM
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
        <h1>Result</h1>
        <p>
            <c:out value="Amount: $${amountOfBill}" />
        </p>
        <p>
            <c:out value="Tip %: ${tipPercent}" />
        </p>
        <p>
            <c:out value="Tip Amount: $${tipAmount}" />
        </p>
        <p>
            <c:out value="Total Bill: $${totalBill}" />
        </p>        
        <p>
            <a href="index.jsp">Calculate Again!</a>
        </p>         
    </body>
</html>
