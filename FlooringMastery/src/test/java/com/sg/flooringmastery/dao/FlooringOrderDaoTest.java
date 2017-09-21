/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class FlooringOrderDaoTest {
    
    FlooringOrderDao orderDao = new FlooringOrderDaoInMemImpl();
    //FlooringProductDao productDao = new FlooringOrderDaoInMemImpl();
    //FlooringTaxDao taxDao  = new FlooringOrderDaoInMemImpl();
    //FlooringUniqueOrderNumberDao uniqueOrderNumberDao  = new FlooringOrderDaoInMemImpl();
    
    
    public FlooringOrderDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        orderDao.clearOrders();
    }
    
    @After
    public void tearDown() {
        orderDao.clearOrders();
    }

    /**
     * Test of addOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testAddOrderAndGetOrderByNum() throws Exception {
        
        LocalDate order1Date = LocalDate.parse("1111-11-11");
        
        Order order1 = new Order(1);
//        order1.setOrderDate(LocalDate.parse("1111-11-11"));
                
        order1.setCustomerName("Croyle");
        order1.setFlooringArea(new BigDecimal("44.583"));
        
        order1.setState("OH");
        order1.setProductType("Laminate");
        
        order1.setTaxRate(new BigDecimal("5.75"));
        order1.setCostPerSqFt(new BigDecimal("1.13"));
        order1.setLaborCostPerSqFt(new BigDecimal("0.45"));
        order1.setMaterialCost(new BigDecimal("454.26"));
        order1.setLaborCost(new BigDecimal("236.47"));
        order1.setTotalTax(new BigDecimal("23.74"));
        order1.setTotalCost(new BigDecimal("684.35"));
        
        orderDao.addOrder(order1, order1Date);
        
        Order testOrder = orderDao.getOrderByNum(1, order1Date);
        
        // Compare Strings
        assertTrue(order1.getCustomerName().equals(testOrder.getCustomerName()));
        assertTrue(order1.getState().equals(testOrder.getState()));
        assertTrue(order1.getProductType().equals(testOrder.getProductType()));
        // Compare BigDecimals
        assertTrue(order1.getFlooringArea().compareTo(testOrder.getFlooringArea()) == 0);
        assertTrue(order1.getTaxRate().compareTo(testOrder.getTaxRate()) == 0);
        assertTrue(order1.getCostPerSqFt().compareTo(testOrder.getCostPerSqFt()) == 0);
        assertTrue(order1.getLaborCostPerSqFt().compareTo(testOrder.getLaborCostPerSqFt()) == 0);
        assertTrue(order1.getMaterialCost().compareTo(testOrder.getMaterialCost()) == 0);
        assertTrue(order1.getLaborCost().compareTo(testOrder.getLaborCost()) == 0);
        assertTrue(order1.getTotalTax().compareTo(testOrder.getTotalTax()) == 0);
        assertTrue(order1.getTotalCost().compareTo(testOrder.getTotalCost()) == 0);

    }

    /**
     * Test of removeOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        
        LocalDate order1Date = LocalDate.parse("1111-11-11");
        
        Order order1 = new Order(1);
                
        order1.setCustomerName("Croyle");
        order1.setFlooringArea(new BigDecimal("44.583"));
        
        order1.setState("OH");
        order1.setProductType("Laminate");
        
        order1.setTaxRate(new BigDecimal("5.75"));
        order1.setCostPerSqFt(new BigDecimal("1.13"));
        order1.setLaborCostPerSqFt(new BigDecimal("0.45"));
        order1.setMaterialCost(new BigDecimal("454.26"));
        order1.setLaborCost(new BigDecimal("236.47"));
        order1.setTotalTax(new BigDecimal("23.74"));
        order1.setTotalCost(new BigDecimal("684.35"));
        
        orderDao.addOrder(order1, order1Date);

        orderDao.removeOrder(1, order1Date);
        
        assertNull(orderDao.getOrderByNum(1, order1Date));
    }

    /**
     * Test of editOrder method, of class FlooringOrderDao.
     */
    @Test
    public void testEditOrder() throws Exception {
        
        LocalDate order1Date = LocalDate.parse("1111-11-11");
        
        Order order1 = new Order(1);
                
        order1.setCustomerName("Croyle");
        order1.setFlooringArea(new BigDecimal("44.583"));
        
        order1.setState("OH");
        order1.setProductType("Laminate");
        
        order1.setTaxRate(new BigDecimal("5.75"));
        order1.setCostPerSqFt(new BigDecimal("1.13"));
        order1.setLaborCostPerSqFt(new BigDecimal("0.45"));
        order1.setMaterialCost(new BigDecimal("454.26"));
        order1.setLaborCost(new BigDecimal("236.47"));
        order1.setTotalTax(new BigDecimal("23.74"));
        order1.setTotalCost(new BigDecimal("684.35"));
        
        orderDao.addOrder(order1, order1Date);
        
        Order order2 = new Order();
        
        LocalDate order2Date = LocalDate.parse("1212-12-11");
        
        order2.setCustomerName("Doyle");
        order2.setFlooringArea(new BigDecimal("44.583"));
        
        order1.setState("MI");
        order1.setProductType("Laminate");
        
        order1.setTaxRate(new BigDecimal("5.75"));
        order1.setCostPerSqFt(new BigDecimal("1.13"));
        order1.setLaborCostPerSqFt(new BigDecimal("0.65"));
        order1.setMaterialCost(new BigDecimal("454.26"));
        order1.setLaborCost(new BigDecimal("236.47"));
        order1.setTotalTax(new BigDecimal("23.72"));
        order1.setTotalCost(new BigDecimal("684.35"));
        
        orderDao.editOrder(order1, order1Date);
        
        Order testOrder = orderDao.getOrderByNum(1, order1Date);
        
        // Compare Strings
        assertFalse(order1.getCustomerName().equals(testOrder.getCustomerName()));
        assertTrue(order1.getState().equals(testOrder.getState()));
        assertTrue(order1.getProductType().equals(testOrder.getProductType()));
        // Compare BigDecimals
        assertTrue(order1.getFlooringArea().compareTo(testOrder.getFlooringArea()) == 0);
        assertTrue(order1.getTaxRate().compareTo(testOrder.getTaxRate()) == 0);
        assertTrue(order1.getCostPerSqFt().compareTo(testOrder.getCostPerSqFt()) == 0);
        assertTrue(order1.getLaborCostPerSqFt().compareTo(testOrder.getLaborCostPerSqFt()) == 0);
        assertTrue(order1.getMaterialCost().compareTo(testOrder.getMaterialCost()) == 0);
        assertTrue(order1.getLaborCost().compareTo(testOrder.getLaborCost()) == 0);
        assertTrue(order1.getTotalTax().compareTo(testOrder.getTotalTax()) == 0);
        assertTrue(order1.getTotalCost().compareTo(testOrder.getTotalCost()) == 0);        
        
    }

    /**
     * Test of getAllOrdersByDate method, of class FlooringOrderDao.
     */
    @Test
    public void testGetAllOrdersByDate() throws Exception {
        
        List<Order> orderList;
        
        Order order1 = new Order(1);
        Order order2 = new Order(2);
        Order order3 = new Order(3);
                
        orderDao.addOrder(order1, LocalDate.parse("1111-11-11"));
        orderDao.addOrder(order2, LocalDate.parse("1112-11-12"));
        orderDao.addOrder(order3, LocalDate.parse("1112-11-12"));
        
        orderList = orderDao.getAllOrdersByDate(LocalDate.parse("1111-11-11"));
        assertEquals(1, orderList.size());

        orderList = orderDao.getAllOrdersByDate(LocalDate.parse("1112-11-12"));
        assertEquals(2, orderList.size());
        
        orderList = orderDao.getAllOrdersByDate(LocalDate.parse("1113-11-11"));
        assertEquals(0, orderList.size());
        
    }
    
}
