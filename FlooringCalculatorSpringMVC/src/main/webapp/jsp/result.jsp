<%-- 
    Document   : result
    Created on : Oct 4, 2017, 9:12:01 PM
    Author     : jeffc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:out value="Your flooring cost: $${flooringCost}" />
        </p>
        <p>
            <c:out value="Your labor cost: $${laborCost} " />
        </p>
        <p>
            <c:out value="Your time required (in hours): ${timeRequired} " />
        </p>
        <p>
            <c:out value="Your total cost: $${totalCost} " />
        </p>          
        <p>
            <a href="index.jsp">Floor Another One!</a>
        </p>
    </body>
</html>
