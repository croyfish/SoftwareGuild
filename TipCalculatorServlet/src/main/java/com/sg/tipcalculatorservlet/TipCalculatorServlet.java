/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculatorservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
@WebServlet(name = "TipCalculatorServlet", urlPatterns = {"/TipCalculatorServlet"})
public class TipCalculatorServlet extends HttpServlet {

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
        BigDecimal amountOfBill = new BigDecimal("0");
        BigDecimal tipPercent = new BigDecimal("0");
        
        // outputs
        BigDecimal tipAmount = new BigDecimal("0");
        BigDecimal totalBill = new BigDecimal("0");
        
        // get inputs
        
        String amountOfBillString = request.getParameter("amountOfBill");
        amountOfBill = new BigDecimal(amountOfBillString).setScale(2, RoundingMode.HALF_UP);  

        String tipPercentString = request.getParameter("tipPercent");
        tipPercent = new BigDecimal(tipPercentString);
        
        // calculate
        
        tipAmount = amountOfBill.multiply(tipPercent.multiply(new BigDecimal("0.01"))).setScale(2, RoundingMode.HALF_UP);
        totalBill = amountOfBill.add(tipAmount).setScale(2, RoundingMode.HALF_UP);
        
        // send outputs
        
        request.setAttribute("amountOfBill", amountOfBill.toString());
        request.setAttribute("tipPercent", tipPercent.toString());
        request.setAttribute("tipAmount", tipAmount.toString());
        request.setAttribute("totalBill", totalBill.toString());

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
