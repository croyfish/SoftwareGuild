/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dao.exception.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jeffc
 */
public class FlooringProductDaoFileImpl implements FlooringProductDao {

    private static final String FILE_HEADER = "ProductType,CostPerSquareFoot,LaborCostPerSquareFoot";
    private String directory;
    private static final String DELIMITER = ",";
    
    private Map<String, Product> productMap;
    
    
    public FlooringProductDaoFileImpl(String directory) throws FlooringPersistenceException {
        this.productMap = productMap;
        readProductFile();
    }    
    
    
    @Override
    public Product addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product removeProduct(String productType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product editProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProductByType(String productType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void readProductFile() throws FlooringPersistenceException {
        
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("data/products/Products.txt")));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException (
                "No product list was found.", e);
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
            Product currentProduct = new Product(currentTokens[0]);
            currentProduct.setCostPerSqFt(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCostPerSqFt(new BigDecimal(currentTokens[2]));
            
            productMap.put(currentProduct.getProductType(), currentProduct);
        }
        
        scanner.close();
    }
    
//    private void writeOrderFile(LocalDate currentDate) throws FlooringPersistenceException {
//        
//        PrintWriter out;
//        
//        try {
//            out = new PrintWriter(new FileWriter(directory + "orders/" + "Orders_" + currentDate.toString()));
//        } catch (IOException e) {
//            throw new FlooringPersistenceException(
//                    "Could not save order data.", e);
//        }
//        
//        Collection<Order> orderCollection = orderMap.values();
//        
//        out.println(FILE_HEADER);
//        
//        for (Order currentOrder : orderCollection) {
//            out.println(currentOrder.getOrderNumber() + DELIMITER
//                    + currentOrder.getCustomerName() + DELIMITER
//                    + currentOrder.getState() + DELIMITER
//                    + currentOrder.getTaxRate().toString() + DELIMITER
//                    + currentOrder.getProductType() + DELIMITER
//                    + currentOrder.getFlooringArea().toString() + DELIMITER
//                    + currentOrder.getCostPerSqFt().toString() + DELIMITER
//                    + currentOrder.getLaborCostPerSqFt().toString() + DELIMITER
//                    + currentOrder.getMaterialCost().toString() + DELIMITER
//                    + currentOrder.getLaborCost().toString() + DELIMITER
//                    + currentOrder.getTotalTax().toString() + DELIMITER
//                    + currentOrder.getTotalCost().toString());
//            out.flush();
//        }
//        
//        out.close();        
//    }
    
}
