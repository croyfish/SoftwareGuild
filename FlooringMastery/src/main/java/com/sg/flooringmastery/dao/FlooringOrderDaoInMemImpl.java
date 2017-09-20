/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public class FlooringOrderDaoInMemImpl implements FlooringOrderDao {
    
    private Map<Integer, Order> orderMap = new HashMap<>();

    @Override
    public Order addOrder(Order order, LocalDate date) {
        Order put = orderMap.put(order.getOrderNumber(), order);
        return order;
    }

    @Override
    public Order removeOrder(Integer orderNumber, LocalDate date) {
        Order removedOrder = orderMap.get(orderNumber);
        orderMap.remove(orderNumber);
        return removedOrder;
    }

    @Override
    public Order editOrder(Order order, LocalDate date) {
//        orderMap.put(order.getOrderNumber(), order);
//        return order;
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    @Override
    public Order getOrderByNum(Integer orderNum, LocalDate date) {
          return orderMap.get(orderNum);
    }

    @Override
    public List<Order> getAllOrdersByDate(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void clearOrders() {
        Map<Integer,Order> orders = new HashMap<Integer, Order>();
    }
    
}
