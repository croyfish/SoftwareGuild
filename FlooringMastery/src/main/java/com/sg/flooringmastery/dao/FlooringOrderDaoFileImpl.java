/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dao.exception.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
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
    
    public void clearOrders(Map<Integer, Order> orderMap) {
        orderMap = new HashMap<>();
    }
    
    private void readOrderFile(String orderFile) {
 Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDERS_DIR + currentDate.toString())));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException(
                "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Student currentStudent = new Student(Integer.parseInt(currentTokens[0]));
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);
            
            students.put(currentStudent.getStudentID(), currentStudent);
        }
        
        scanner.close();
    }
    
    private void writeRoster() throws FlooringPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ORDERS_DIR + currentDate.toString()));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException(
                    "Could not save address data.", e);
        }
        
        List<Student> addressList = this.getAllStudents();
        for (Student currentStudent : addressList) {
            out.println(currentStudent.getStudentID() + DELIMITER
                    + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());
            out.flush();
        }
        
        out.close();        
    }
    
}
