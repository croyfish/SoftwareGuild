/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.exception.NoProductException;
import com.sg.flooringmastery.dto.Product;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jeffc
 */
public class ProductServiceTest {
    
    FlooringProductService productService;
    
    public ProductServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /** arrange, act, assert
     * Test of fillMaterialCostPerSqFtField method, of class ProductService.
     */
//    @Test
//    public void testFillMaterialCostPerSqFtField() {
//        
//        
//        
//        Order filledOrder = productService.fillMaterialCostPerSqFtField(order);
//        
//        
//    }
//
//    /** arrange, act, assert
//     * Test of fillLaborCostPerSqFtField method, of class ProductService.
//     */
//    @Test
//    public void testFillLaborCostPerSqFtField() {
//    }

    /** arrange, act, assert
     * Test of addProduct method, of class ProductService.
     */
    @Test
    public void testAddProduct() {
        Product product1 = new Product("Mahogany");
        product1.setCostPerSqFt(new BigDecimal("0.17"));
        product1.setLaborCostPerSqFt(new BigDecimal("45.89"));
        
        Product addedProduct = productService.addProduct(product1);
        
        // call product with get and check fields
         
        Product gotProduct;
        
        try{
            gotProduct = productService.getProductByType("Mahogany");
            assertEquals(new BigDecimal("0.17"), gotProduct.getCostPerSqFt());
            assertEquals(new BigDecimal("45.89"), gotProduct.getLaborCostPerSqFt());
            assertEquals("Mahogany", gotProduct.getProductType());
        } catch(NoProductException ex) {
             fail("The product couldn't be found");
        }

    }

    /** arrange, act, assert
     * Test of removeProduct method, of class ProductService.
     */
    @Test
    public void testRemoveProduct() {
        Product product1 = new Product("Mahogany");
        product1.setCostPerSqFt(new BigDecimal("0.17"));
        product1.setLaborCostPerSqFt(new BigDecimal("45.89"));
        
        Product addedProduct = productService.addProduct(product1);
        
        Product removedProduct;
        
        try {
            removedProduct = productService.removeProduct(product1.getProductType());
        } catch (NoProductException e) {
            fail("The product could not be removed because it was not found (NoProductFoundException).");
        }
        
        try {
            removedProduct = productService.getProductByType(product1.getProductType());
            fail("The expected NoProductException not encountered.");
        } catch (NoProductException e) {
            assertTrue(true);
        }
        
        
        
        
    }

    /** arrange, act, assert
     * Test of editProduct method, of class ProductService.
     */
    @Test
    public void testEditProduct() {
        
        Product product1 = new Product("Mahogany");
        product1.setCostPerSqFt(new BigDecimal("0.17"));
        product1.setLaborCostPerSqFt(new BigDecimal("45.89"));
        
        Product addedProduct = productService.addProduct(product1);    
        
        
        
    }

    /** arrange, act, assert
     * Test of getAllProducts method, of class ProductService.
     */
    @Test
    public void testGetAllProducts() {
    }

    /** arrange, act, assert
     * Test of getProductByType method, of class ProductService.
     */
    @Test
    public void testGetProductByType() {
    }
    
//    public Order fillMaterialCostPerSqFtField(Order order);
//    public Order fillLaborCostPerSqFtField(Order order);
//    public Product addProduct(Product product);
//    public Product removeProduct(String productType);
//    public Product editProduct(Product product);
//    public List<Product> getAllProducts();
//    public Product getProductByType(String productType);    
    
    
}
