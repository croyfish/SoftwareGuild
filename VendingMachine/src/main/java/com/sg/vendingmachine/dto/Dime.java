/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author jeffc
 */
public class Dime {
    
    private final String NAME = "Dime";
    
    private final BigDecimal VALUE = new BigDecimal("0.10");

    public String getNAME() {
        return NAME;
    }

    public BigDecimal getVALUE() {
        return VALUE;
    }
    
}
