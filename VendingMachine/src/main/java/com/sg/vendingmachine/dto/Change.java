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
public class Change {
    private Integer quarters;
    private Integer dimes;
    private Integer nickels;
    private Integer pennies;
    
    public Change() {
        quarters = 0;
        dimes = 0;
        nickels = 0;
        pennies = 0;
    }
    
    // Override toString method to print change's value when LoggingAdvice prints the parameter's values
    @Override
    public String toString() {
    return "$" + getValueOfChange();
    }

    // Method to reset all change fields to zero
    public void setChangeToZero() {
        this.setPennies(0);
        this.setNickels(0);
        this.setDimes(0);
        this.setQuarters(0);
    }
    
    public Integer getQuarters() {
        return quarters;
    }

    public void setQuarters(Integer quarters) {
        this.quarters = quarters;
    }

    public Integer getDimes() {
        return dimes;
    }

    public void setDimes(Integer dimes) {
        this.dimes = dimes;
    }

    public Integer getNickels() {
        return nickels;
    }

    public void setNickels(Integer nickels) {
        this.nickels = nickels;
    }

    public Integer getPennies() {
        return pennies;
    }

    public void setPennies(Integer pennies) {
        this.pennies = pennies;
    }
    
    // Get BigDecimal USD value of only pennies in change object
    public BigDecimal getValueOfPennies() {
        return new BigDecimal(new BigDecimal(this.getPennies().toString())
                .multiply(new BigDecimal("0.01")).toString());
    } 
    // Get BigDecimal USD value of only nickels in change object
    public BigDecimal getValueOfNickels() {
        return new BigDecimal(new BigDecimal(this.getNickels().toString())
                .multiply(new BigDecimal("0.05")).toString());
    }    
    // Get BigDecimal USD value of only dimes in change object
    public BigDecimal getValueOfDimes() {
        return new BigDecimal(new BigDecimal(this.getDimes().toString())
                .multiply(new BigDecimal("0.1")).toString());
    } 
    /// Get BigDecimal USD value of only quarters in change object
    public BigDecimal getValueOfQuarters() {
        return new BigDecimal(new BigDecimal(this.getQuarters().toString())
                .multiply(new BigDecimal("0.25")).toString());
    }
    
    // Get total value of change object in USD as a big decimal
    public BigDecimal getValueOfChange() {
        return new BigDecimal(getValueOfPennies().add(getValueOfNickels())
            .add(getValueOfDimes()).add(getValueOfQuarters()).toString());
    }
}
