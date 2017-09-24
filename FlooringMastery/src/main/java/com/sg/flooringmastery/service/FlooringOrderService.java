/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;

/**
 *
 * @author jeffc
 */
public interface FlooringOrderService {
    
// + List <Order> getOrdersByDate(LocalDate)
// +Order getOrderByNumber(Integer, LocalDate)
// +Order addNewOrder(Order)
// +Order addEditedOrder(Order)
// +Order removeOrder(Order)
// + BigDecimal calculateTotalCost(Order)
// +void saveWork()
// <<constructor>>
// + OrderService(FlooringOrderDao flooringDao,
// ProductService productService, TaxService taxService)

    // create
    public Order addNewOrder(Order order);
    // read
    public Order getOrderByNumber(Integer orderNumber, LocalDate orderDate);
    // update
    public Order addEditedOrder(Order order);
    // delete
    public Order removeOrder(Integer orderNumber, LocalDate orderDate);
    
    
    
    
    
}
