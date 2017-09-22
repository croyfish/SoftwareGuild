/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dao.exception.NoOrdersForDateException;
import com.sg.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jeffc
 */
public class FlooringOrderDaoInMemImpl implements FlooringOrderDao {
    
    private Map<LocalDate, List<Order>> orderMap;
    private LocalDate currentDate;
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy"); // format for file
    
    private static final String DELIMITER = ",";
    
    public FlooringOrderDaoInMemImpl () {
        this.orderMap = new HashMap<>();
        currentDate = LocalDate.now();
    }
    
    @Override
    public Order addOrder(Order order, LocalDate date) {
        List<Order> addedOrders = new ArrayList<>();
        try {
        addedOrders = orderMap.get(date);
        if (addedOrders == null) {
            addedOrders = new ArrayList<>(Arrays.asList(order));
        } else {
        addedOrders.add(order);
        }
        orderMap.put(date, addedOrders);
        return order;
        } catch (NullPointerException ex) {
            // throw new exception
        }
        return null;
    }

    @Override
    public Order removeOrder(Integer orderNum, LocalDate date) {
        List<Order> removeOrders = new ArrayList<>();
        try {
            removeOrders = orderMap.get(date);
            for (Order removeOrder : removeOrders) {
                if (removeOrder.getOrderNumber().equals(orderNum)) {
                    removeOrders.remove(removeOrder); // This probably doesn't work!
                    orderMap.put(date, removeOrders);
                    return removeOrder;
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
        orderMap.clear();
    }
    
    private void readOrderFile(LocalDate currentDate) throws NoOrdersForDateException {
        
        clearOrders();
        
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("data/orders/" + "Orders_" + currentDate.toString()))); // check!!!!!!
        } catch (FileNotFoundException e) {
            throw new NoOrdersForDateException (
                "No orders found for given date.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        Integer lineCounter = 0;
        List<Order> currentOrders = new ArrayList<>();
        
        
        while (scanner.nextLine().length() != 0) {
            currentLine = scanner.nextLine();
            lineCounter++;
            if (lineCounter == 1) {
                continue;
            }
            currentTokens = currentLine.split(DELIMITER);
            Order currentOrder = new Order(Integer.parseInt(currentTokens[0]));
            currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setState(currentTokens[2]);
            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
            currentOrder.setProductType(currentTokens[4]);
            currentOrder.setFlooringArea(new BigDecimal(currentTokens[5]));
            currentOrder.setCostPerSqFt(new BigDecimal(currentTokens[6]));
            currentOrder.setLaborCostPerSqFt(new BigDecimal(currentTokens[7]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
            currentOrder.setTotalTax(new BigDecimal(currentTokens[10]));
            currentOrder.setTotalCost(new BigDecimal(currentTokens[11]));
            
            currentOrders.add(currentOrder);
        }
        
        orderMap.put(currentDate, currentOrders);
        
        scanner.close();
    }    
    
}
