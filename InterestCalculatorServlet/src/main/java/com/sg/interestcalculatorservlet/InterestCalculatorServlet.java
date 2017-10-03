/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculatorservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeffc
 */
@WebServlet(name = "InterestCalculatorServlet", urlPatterns = {"/InterestCalculatorServlet"})
public class InterestCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // inputs
        BigDecimal annualInterestRate = new BigDecimal("0");
        BigDecimal amountOfPrinciple = new BigDecimal("0");
        Integer numberOfYears = 0;

        // intermediaries
        BigDecimal principleBalanceAtBeginningOfQuarter = new BigDecimal("0");
        BigDecimal principleBalanceAtEndOfQuarter = new BigDecimal("0");
        BigDecimal interestEarnedForQuarter = new BigDecimal("0");
        BigDecimal quarterlyInterestRate = new BigDecimal("0");
        Integer yearNumber = 0;
        BigDecimal principleBalanceAtBeginningOfYear = new BigDecimal("0");
        BigDecimal principleBalanceAtEndOfYear = new BigDecimal("0");
        BigDecimal interestEarnedForYear = new BigDecimal("0");

        // outputs
        List<String> yearNumbers = new ArrayList<>();
        List<String> principleBalanceAtBeginningOfYears = new ArrayList<>();
        List<String> interestEarnedForYears = new ArrayList<>();
        List<String> principleBalanceAtEndOfYears = new ArrayList<>();


        // take inputs

        String annualInterestRateString = request.getParameter("annualInterestRate");
        annualInterestRate = new BigDecimal(annualInterestRateString);

        String amountOfPrincipleString = request.getParameter("amountOfPrinciple");
        amountOfPrinciple = new BigDecimal(amountOfPrincipleString);

        String numberOfYearsString = request.getParameter("numberOfYears");
        numberOfYears = Integer.parseInt(numberOfYearsString);


        // calculate intermediate values

        quarterlyInterestRate = annualInterestRate.divide(new BigDecimal("4"));
        principleBalanceAtBeginningOfYear = amountOfPrinciple;
        principleBalanceAtEndOfYear = amountOfPrinciple;

        // yearly loop
        for (int currentYear = 0; currentYear < numberOfYears; currentYear++) {

            principleBalanceAtBeginningOfYear = principleBalanceAtEndOfYear;
            principleBalanceAtBeginningOfYears.add(principleBalanceAtBeginningOfYear.toString()) ;
            interestEarnedForYear = new BigDecimal("0");
            principleBalanceAtEndOfQuarter = principleBalanceAtBeginningOfYear;

            // quarterly loop
            for (int currentQuarter = 1; currentQuarter <= 4; currentQuarter++) {

                principleBalanceAtBeginningOfQuarter = principleBalanceAtEndOfQuarter;
                interestEarnedForQuarter = new BigDecimal("0");

                // interest calculation
                principleBalanceAtEndOfQuarter = principleBalanceAtBeginningOfQuarter.multiply(
                    ((new BigDecimal("1")).add(quarterlyInterestRate.divide(new BigDecimal("100"))))).setScale(2, RoundingMode.HALF_UP);

                interestEarnedForQuarter = principleBalanceAtEndOfQuarter.subtract(principleBalanceAtBeginningOfQuarter).setScale(2, RoundingMode.HALF_UP);
                interestEarnedForYear = interestEarnedForYear.add(interestEarnedForQuarter).setScale(2, RoundingMode.HALF_UP);

            }

            principleBalanceAtEndOfYear = principleBalanceAtEndOfQuarter;

        // update lists    
            yearNumbers.add(String.valueOf(currentYear + 1));
            interestEarnedForYears.add(interestEarnedForYear.toString());
            principleBalanceAtEndOfYears.add(principleBalanceAtEndOfYear.toString());

        }

        request.setAttribute("yearNumbers", yearNumbers);
        request.setAttribute("principleBalanceAtBeginningOfYears", principleBalanceAtBeginningOfYears);
        request.setAttribute("interestEarnedForYears", interestEarnedForYears);
        request.setAttribute("principleBalanceAtEndOfYears", principleBalanceAtEndOfYears);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);



    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
