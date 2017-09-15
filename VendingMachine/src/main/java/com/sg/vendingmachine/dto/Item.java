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
public class Item {
    
    private String SKU;
    private String name;
    private BigDecimal price;
    private Integer inStock;

    public Item(String SKU) {
        this.SKU = SKU;
    }
    
    @Override
    public String toString() {
    return " SKU: " + SKU + " | Item name: " + name + " | In stock: " + inStock + "items";
    }
    
    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }
    
    
}
