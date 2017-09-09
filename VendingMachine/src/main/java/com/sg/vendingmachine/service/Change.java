/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author jeffc
 */
public class Change {
    private Integer quarters;
    private Integer dimes;
    private Integer nickels;
    private Integer pennies;

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
    
}
