/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculatorspringmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
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
public class InterestCalculatorController {
    
    @RequestMapping(value="/calculateInterest", method=RequestMethod.POST)
    public String calculateInterest(HttpServletRequest request, Map<String, Object> model) {
        
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
               
        
        
        
    model.put("yearNumbers", yearNumbers);
    model.put("principleBalanceAtBeginningOfYears", principleBalanceAtBeginningOfYears);
    model.put("interestEarnedForYears", interestEarnedForYears);
    model.put("principleBalanceAtEndOfYears", principleBalanceAtEndOfYears);
    return "result";        
        
    }    
}
