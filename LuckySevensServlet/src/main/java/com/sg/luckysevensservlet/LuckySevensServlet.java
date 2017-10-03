/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;
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
@WebServlet(name = "LuckySevensServlet", urlPatterns = {"/LuckySevensServlet"})
public class LuckySevensServlet extends HttpServlet {

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
        Integer moneyToBet = 0;
        
        // intermediaries
        Integer currentMoney = 0;
        Integer currentRoll = 0;
        Random dice1 = new Random();
        Random dice2 = new Random();
        Integer currentTotal = 0;
        
        // outputs
        Integer numberOfRollsTaken = 0;
        Integer maxAmountOfMoney = 0;
        Integer numberOfRollsAtMax = 0;
        
        // get inputs
        String moneyToBetString = request.getParameter("moneyToBet");
        moneyToBet = Integer.parseInt(moneyToBetString);        
        
        // calculate intermediate values
        currentMoney = moneyToBet;
        maxAmountOfMoney = currentMoney;
        
        // game loop
        
        while (!currentMoney.toString().equals("0")) {
            currentRoll++;
            currentTotal = dice1.nextInt(6) + dice2.nextInt(6) + 2;
            if (currentTotal == 7) {
                currentMoney += 4;
            } else {
                currentMoney -= 1;
            }
            if (currentMoney > maxAmountOfMoney) {
                maxAmountOfMoney = currentMoney;
                numberOfRollsAtMax = currentRoll;
            }
        }
        
        numberOfRollsTaken = currentRoll;
        
        request.setAttribute("moneyToBet", moneyToBet);
        request.setAttribute("numberOfRollsTaken", numberOfRollsTaken);
        request.setAttribute("maxAmountOfMoney", maxAmountOfMoney);
        request.setAttribute("numberOfRollsAtMax", numberOfRollsAtMax);

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
