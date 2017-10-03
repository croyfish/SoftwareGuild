<%-- 
    Document   : index
    Created on : Oct 3, 2017, 1:33:13 PM
    Author     : jeffc
--%>

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
            <form method="POST" action="TipCalculatorServlet">
                <label>Amount of bill (in USD): </label>
                <input type="text" name="amountOfBill">
                <label>Tipping percent: </label>
                <input type="text" name="tipPercent">                
                <input type ="submit" value="Calculate!!!">
            </form>
        </p>        
    </body>
</html>
