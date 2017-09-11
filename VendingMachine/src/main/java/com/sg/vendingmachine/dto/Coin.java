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
public class Coin {
    
    private final String SINGULAR_NAME;
    private final String PLURAL_NAME;
    private final BigDecimal VALUE;

    public Coin (String singularName, String pluralName, BigDecimal value) {
        this.SINGULAR_NAME = singularName;
        this.PLURAL_NAME = pluralName;
        this.VALUE = value;
    }

    public String getSINGULAR_NAME() {
        return SINGULAR_NAME;
    }

    public String getPLURAL_NAME() {
        return PLURAL_NAME;
    }

    public BigDecimal getVALUE() {
        return VALUE;
    }

}
