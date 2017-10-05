/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator.service;

import java.math.BigDecimal;

/**
 *
 * @author jeffc
 */
public interface InterestCalculatorService {
    
    public BigDecimal getQuarterlyInterestRate(BigDecimal yearlyInterestRate);
    
    
}
