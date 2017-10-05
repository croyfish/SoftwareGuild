/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorspringmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jeffc
 */
@Controller
public class FlooringCalculatorController {
    
    @RequestMapping(value="/calculateFlooringCosts", method=RequestMethod.POST)
    public String calculateFlooringCosts(HttpServletRequest request, Map<String, Object> model) {
        
    // inputs
        BigDecimal width = new BigDecimal("0");
        BigDecimal length = new BigDecimal("0");
        BigDecimal costPerSqFt = new BigDecimal("0");

        // intermediaries
        BigDecimal area = new BigDecimal("0");
        BigDecimal hours = new BigDecimal("0");
        Integer increments = 0;

        // outputs
        BigDecimal flooringCost = new BigDecimal("0");
        BigDecimal laborCost = new BigDecimal("0");
        BigDecimal timeRequired = new BigDecimal("0");
        BigDecimal totalCost = new BigDecimal("0");

        // take inputs

        String widthString = request.getParameter("width");
        width = new BigDecimal(widthString);

        String lengthString = request.getParameter("length");
        length = new BigDecimal(lengthString);

        String costPerSqFtString = request.getParameter("costPerSqFt");
        costPerSqFt = new BigDecimal(costPerSqFtString);

        // calculate intermediate values

        area = width.multiply(length);
        hours = area.divide(new BigDecimal("20"), 2, RoundingMode.HALF_UP);
        increments = (int) Math.ceil(hours.multiply(new BigDecimal("4")).intValue());

        // calculate outputs

        flooringCost = area.multiply(costPerSqFt).setScale(2, RoundingMode.HALF_UP);
        laborCost = new BigDecimal(increments).divide(new BigDecimal("4")).multiply(new BigDecimal("86")).setScale(2, RoundingMode.HALF_UP);
        timeRequired = hours.setScale(2, RoundingMode.HALF_UP);
        totalCost = flooringCost.add(laborCost).setScale(2, RoundingMode.HALF_UP);
          
        model.put("flooringCost", flooringCost);
        model.put("laborCost", laborCost);
        model.put("timeRequired", timeRequired);
        model.put("totalCost", totalCost);
        return "result";
    }
    
}