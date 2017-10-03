<%-- 
    Document   : index
    Created on : Oct 3, 2017, 10:47:29 AM
    Author     : jeffc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>
    </head>
    <body>
        <h1>Interest Calculator</h1>
        
        <p>
            Please enter all of your interest needs:
        </p>
        
        <p>
            <form method="POST" action="InterestCalculatorServlet">
                <label>Annual Interest Rate (in %): </label>
                <input type="text" name="annualInterestRate">
                <label>Amount Of Principle (in USD): </label>
                <input type="text" name="amountOfPrinciple">
                <label>Number of Years: </label>
                <input type="text" name="numberOfYears">
                <input type ="submit" value="Calculate!!!">
            </form>
        </p>
    </body>
</html>
