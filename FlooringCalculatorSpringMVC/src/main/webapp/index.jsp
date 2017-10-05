<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <title>Flooring Calculator</title>
            <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
                  rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Flooring Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentaiton"
                        class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Flooring Calculator Controller
                        </a>    
                    </li>
                </ul>
            </div>
            <h2>Choose a number to factor:</h2>
            <form method="POST" action="calculateFlooringCosts">
                <label>Width (in feet): </label>
                <input type="text" name="width" />
                <label>Length (in feet): </label>
                <input type="text" name="length" />
                <label>Cost per square foot (in USD): </label>
                <input type="text" name="costPerSqFt" />
                <input type ="submit" value="Calculate!!!" />
            </form>     
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

