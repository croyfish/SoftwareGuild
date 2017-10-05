/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculatorspringmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jeffc
 */
@Controller
public class TipCalculatorController {

    @RequestMapping(value="/calculateTip", method=RequestMethod.POST)
    public String calculateTip(HttpServletRequest request, Map<String, Object> model) { 

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
        
        model.put("amountOfBill", amountOfBill.toString());
        model.put("tipPercent", tipPercent.toString());
        model.put("tipAmount", tipAmount.toString());
        model.put("totalBill", totalBill.toString());
        return "result";
        
    }   
}
