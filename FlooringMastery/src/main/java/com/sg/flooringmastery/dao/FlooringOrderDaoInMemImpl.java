/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public class FlooringOrderDaoInMemImpl implements FlooringOrderDao {
    
    private Map<LocalDate, List<Order>> orderMap = new HashMap<>();

    @Override
    public Order addOrder(Order order, LocalDate date) {
        List<Order> currentOrders = new ArrayList<>();
        try {
        currentOrders = orderMap.get(date);
        currentOrders.add(order);
        orderMap.put(date, currentOrders);
        return order;
        } catch (NullPointerException ex) {
            // throw new exception
        }
        return null;
    }

    @Override
    public Order removeOrder(Integer orderNum, LocalDate date) {
        List<Order> currentOrders = new ArrayList<>();
        try {
            currentOrders = orderMap.get(date);
            for (Order currentOrder : currentOrders) {
                if (currentOrder.getOrderNumber().equals(orderNum)) {
                    currentOrders.remove(currentOrder); // This probably doesn't work!
                    orderMap.put(date, currentOrders);
                    return currentOrder;
                } 
            }
        } catch (NullPointerException ex) {
            // throw new exception
        }
        return null;
    }

    @Override
    public Order editOrder(Order order, LocalDate oldDate, LocalDate newDate) {
        List<Order> currentOrders = new ArrayList<>();
        currentOrders = orderMap.get(oldDate);
        removeOrder(order.getOrderNumber(), oldDate);
        try {
            currentOrders.add(order);
            orderMap.put(newDate, currentOrders);
            return order;
        } catch (NullPointerException ex) {
            
        }
        return null;
    }

    @Override
    public Order getOrderByNum(Integer orderNum, LocalDate date) {
        List<Order> currentOrders  = new ArrayList<>();
        currentOrders = orderMap.get(date);
        try {
            for (Order currentOrder : currentOrders) {
                if (currentOrder.getOrderNumber().equals(orderNum)) {
                    return currentOrder;
                } 
            } 
                    
        } catch (NullPointerException ex) {
            
        }
        return null;    
    }

    @Override
    public List<Order> getAllOrdersByDate(LocalDate date) {
        try {
            return orderMap.get(date);
        } catch (NullPointerException ex) {
            
        }
        return null;
    }
    
    public void clearOrders() {
        orderMap = new HashMap<>();
    }
    
}
