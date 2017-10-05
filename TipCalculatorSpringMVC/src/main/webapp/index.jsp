<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
    <body>
        <h1>Tip Calculator</h1>
        <p>
            <form method="POST" action="calculateTip">
                <label>Amount of bill (in USD): </label>
                <input type="text" name="amountOfBill">
                <label>Tipping percent: </label>
                <input type="text" name="tipPercent">                
                <input type ="submit" value="Calculate!!!">
            </form>
        </p>        
    </body>
</html>

