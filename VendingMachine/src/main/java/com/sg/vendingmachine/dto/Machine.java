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
public class Machine {
    
    private BigDecimal moneyEntered;
    private int rows, columns;
    private Item[][] stock;
    
    public Machine(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++)
                    stock[row][col] = null;
            }
        this.moneyEntered = new BigDecimal("0.00");
    }

    public BigDecimal getMoneyEntered() {
        return moneyEntered;
    }

    public void setMoneyEntered(BigDecimal moneyEntered) {
        this.moneyEntered = moneyEntered;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Item[][] getStock() {
        return stock;
    }

    public void setStock(Item[][] stock) {
        this.stock = stock;
    }
    
    
    
}
