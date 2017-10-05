<%-- 
    Document   : result
    Created on : Oct 4, 2017, 9:44:17 PM
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
            <c:forEach var="yearNumber" items="${yearNumbers}">
                <c:out value="Year ${yearNumber}    " />
            </c:forEach>
        </p>
        <p>
            <c:forEach var="principleBalanceAtBeginningOfYear" items="${principleBalanceAtBeginningOfYears}">
                <c:out value="$${principleBalanceAtBeginningOfYear}     " />
            </c:forEach>
        </p>
        <p>
            <c:forEach var="interestEarnedForYear" items="${interestEarnedForYears}">
                <c:out value="$${interestEarnedForYear}     " />
            </c:forEach>
        </p>
        <p>
            <c:forEach var="principleBalanceAtEndOfYear" items="${principleBalanceAtEndOfYears}">
                <c:out value="$${principleBalanceAtEndOfYear}    " />
            </c:forEach>
        </p>        
        <p>
            <a href="index.jsp">Calculate Again!</a>
        </p>        
    </body>
</html>
