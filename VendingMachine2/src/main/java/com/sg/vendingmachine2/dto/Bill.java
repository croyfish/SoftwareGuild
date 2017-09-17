/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine2.dto;

import java.math.BigDecimal;

/**
 *
 * @author jeffc
 */
public class Bill extends Denomination {
    
    public Bill (String name, String pluralName, String value) {
    this.name = name;
    this.value = new BigDecimal(value);
    }

    
}
