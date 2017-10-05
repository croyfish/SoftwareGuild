<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <title>Interest Calculator</title>
            <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
                  rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Interest Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"
                        class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Interest Calculator Controller
                        </a>    
                    </li>
                </ul>
            </div>
            <h2>Please enter all of your interest needs:</h2>
            <form method="POST" action="calculateInterest">
                <label>Annual Interest Rate (in %): </label>
                <input type="text" name="annualInterestRate">
                <label>Amount Of Principle (in USD): </label>
                <input type="text" name="amountOfPrinciple">
                <label>Number of Years: </label>
                <input type="text" name="numberOfYears">
                <input type ="submit" value="Calculate!!!">
            </form>   
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

