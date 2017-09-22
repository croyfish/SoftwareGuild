/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dao.exception.FlooringPersistenceException;
import com.sg.flooringmastery.dao.exception.NoOrdersForDateException;
import com.sg.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jeffc
 */
public class FlooringOrderDaoFileImpl implements FlooringOrderDao {
    // Orders Map, with all orders for one day loaded in
    private Map<Integer, Order> orderMap;
    private LocalDate currentDate;
    
    private static final String FILE_HEADER = "OrderNumber,CustomerName,State,"
            + "TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,"
            + "MaterialCost,LaborCost,Tax,Total";
    private static final String ORDERS_DIR = "data/orders/";
    private static final String DELIMITER = ",";

    public FlooringOrderDaoFileImpl() {
        this.orderMap = new HashMap<>();
        currentDate = LocalDate.now();
    }
    
    @Override
    public Order addOrder(Order order, LocalDate date) {
        orderMap.put(order.getOrderNumber(), order);
        return order;
    }

    @Override
    public Order removeOrder(Integer orderNumber, LocalDate date) {
        Order removedOrder = orderMap.get(orderNumber);
        orderMap.remove(orderNumber);
        return removedOrder;
    }

    @Override
    public Order editOrder(Order editedOrder, LocalDate oldDate, LocalDate newDate) {
        removeOrder(editedOrder.getOrderNumber(), oldDate);
        addOrder(editedOrder, newDate);
        return editedOrder;
    }

    @Override
    public Order getOrderByNum(Integer orderNum, LocalDate date) {
        return orderMap.get(orderNum);
    }

    @Override
    public List<Order> getAllOrdersByDate(LocalDate date) {
        List<Order> ordersByDate = new ArrayList<>();
//            for (Order currentOrder : orderMap.values()) {
//                if (currentOrder.getOrderDate().isEqual(date)) {
//                    ordersByDate.add(currentOrder);
//                }
//            }
        return ordersByDate;
    }
    
    public void clearOrders() {
        for (Order currentOrder : orderMap.values()) {
            removeOrder(currentOrder.getOrderNumber(), currentDate);
        }
            
    }
    
    private void readOrderFile(LocalDate currentDate) throws NoOrdersForDateException {
        
        clearOrders();
        
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDERS_DIR + "Orders_" + currentDate.toString()))); // check!!!!!!
        } catch (FileNotFoundException e) {
            throw new NoOrdersForDateException (
                "No orders found for given date.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        Integer lineCounter = 0;
        
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
            
            orderMap.put(currentOrder.getOrderNumber(), currentOrder);
        }
        
        scanner.close();
    }
    
    private void writeOrderFile(LocalDate currentDate) throws FlooringPersistenceException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ORDERS_DIR + "Orders_" + currentDate.toString()));
        } catch (IOException e) {
            throw new FlooringPersistenceException(
                    "Could not save order data.", e);
        }
        
        Collection<Order> orderCollection = orderMap.values();
        
        out.println(FILE_HEADER);
        
        for (Order currentOrder : orderCollection) {
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getState() + DELIMITER
                    + currentOrder.getTaxRate().toString() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder.getFlooringArea().toString() + DELIMITER
                    + currentOrder.getCostPerSqFt().toString() + DELIMITER
                    + currentOrder.getLaborCostPerSqFt().toString() + DELIMITER
                    + currentOrder.getMaterialCost().toString() + DELIMITER
                    + currentOrder.getLaborCost().toString() + DELIMITER
                    + currentOrder.getTotalTax().toString() + DELIMITER
                    + currentOrder.getTotalCost().toString());
            out.flush();
        }
        
        out.close();        
    }
    
}
