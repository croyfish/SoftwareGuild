/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.exception.FlooringPersistenceException;
import com.sg.flooringmastery.exception.NoProductException;
import com.sg.flooringmastery.exception.NoStateException;
import com.sg.flooringmastery.service.FlooringOrderService;
import com.sg.flooringmastery.service.FlooringUniqueOrderNumberService;
import com.sg.flooringmastery.ui.FlooringView;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class FlooringController {
    
    private FlooringView view;
    private FlooringOrderService orderService;
    private FlooringUniqueOrderNumberService uniqueOrderNumberService;
    
    boolean keepGoing = true;
    boolean isTrainingMode = true; //
    
    Integer userChoice = 0;
    
    public FlooringController(FlooringView view, 
            FlooringOrderService orderService, FlooringUniqueOrderNumberService uniqueOrderNumberService) {
        this.view = view;
        this.orderService = orderService;
        this.uniqueOrderNumberService = uniqueOrderNumberService;
    }
    
    public void run() {
        
        view.displayOpeningPage();
        view.displayYouAreInTrainingMode(); //
        view.waitForEnter();
        
        while (keepGoing){
            int actionChoice = view.printActionMenuAndGetSelection(returnModeString(isTrainingMode));
            useActionMenuChoice(actionChoice);
        }
        
    }
    
    public void useActionMenuChoice(int actionChoice) {
        
        switch(actionChoice) {
            case 1: displayOrdersForDate();
                break;
            case 2: addAnOrderToDate();
                break;
            case 3: editAnOrderByDate();
                break;
            case 4: removeAnOrderByDate();
                break;
            case 5: switchApplicationMode();
                break;
            case 6: keepGoing = false;
                break;
            default: view.printInvalidChoiceMessage();
                break;

        }
    }
    void displayOrdersForDate(){
        boolean editing=false;
        view.displayDisplayOrdersBanner();
        
        LocalDate[] enteredDateInfo = view.askForDate(editing);
        try{
            List<Order> ordersForDate = orderService.getOrdersByDate(enteredDateInfo[0]); 
            view.showAllOrdersForDate(ordersForDate, enteredDateInfo[0]); 
        } catch (FlooringPersistenceException ex){
            view.displayExceptionMessage("Orders not found.");
        } catch (NullPointerException ex) {
            view.displayExceptionMessage("Error: There are no orders for that date.");
        }
        
    }

    void addAnOrderToDate(){
        boolean editing = false;
        view.displayAddAnOrderBanner();
        LocalDate[] dateToFile = view.askForDate(editing);
        Order orderWithAllFieldsFilled 
                = new Order(uniqueOrderNumberService.getNewUniqueOrderNumber().getOrderNumber()); 
        
        Order partialNewOrder = view.setBasicOrderInfoForAdd(orderWithAllFieldsFilled, editing);
        
        try{
            orderWithAllFieldsFilled = orderService.fillRemainingOrderFields(partialNewOrder);
        } catch(NoStateException ex){
            view.displayExceptionMessage("Error: The state entered is not in our service area.");
            return;
        } catch(NoProductException ex){
            view.displayExceptionMessage("Error: That product is not sold.");
            return;
        } catch(FlooringPersistenceException e){
            view.displayExceptionMessage("Error: Data file could not be read.");
            return;
        }
        
        boolean inLargeList = false;
        view.showInfoForOneOrder(orderWithAllFieldsFilled, inLargeList);
        
        boolean commit = view.askToCommit("Your order will be committed.");
        if (commit){
            
            try{
                Order addedOrder = orderService.addNewOrder(orderWithAllFieldsFilled, dateToFile[0]);
                view.displayOperationSuccessfulMessage("Add Order");
            } catch(FlooringPersistenceException ex){
                view.displayExceptionMessage("There was a problem persisting the order to file.");
            }
            
            
        } else {
            view.displayOperationAbandonedMessage("Add Order");
        }
        
    }

    void editAnOrderByDate(){
        boolean editing = true;        
        boolean inLargeList = false;
        view.displayEditAnOrderBanner();
        LocalDate[] enteredDateInfo = view.askForDate(editing);     
        
        try{
            List<Order> ordersForOldDate = orderService.getOrdersByDate(enteredDateInfo[0]); //use NoDateException inside for missing dates
            Integer orderNum = view.getOrderNumFromUser();
            Order orderToEdit = orderService.getOrderByNumber(orderNum, enteredDateInfo[0]); //try catch for NoOrderException
            Order partiallyEditedOrder = view.setBasicOrderInfoForEdit(orderToEdit, editing); //has all user input
            Order fullyEditedOrder = orderService.fillRemainingOrderFields(partiallyEditedOrder);
            view.showInfoForOneOrder(fullyEditedOrder, inLargeList);//or a view method like "showInfoForFullyEditedOrder"
            
            boolean commit = view.askToCommit("The previous information will be over-written.");
            if (commit){
                Order addEditedOrder = orderService.addEditedOrder(fullyEditedOrder, enteredDateInfo[0], enteredDateInfo[1]);
                view.displayOperationSuccessfulMessage("Edit Order");
            } else {
                view.displayOperationAbandonedMessage("Edit Order");
            }
        } catch(FlooringPersistenceException ex){
            view.displayExceptionMessage("Error: Orders not retrievable.");
        } catch(NoProductException ex) {
            view.displayExceptionMessage("Error: No product of that type.");
        } catch(NoStateException ex){
            view.displayExceptionMessage("Error: State not serviced.");
        } catch (NullPointerException e) {
            view.displayExceptionMessage("Error: That date does not contain that order number.");
        }
    }
    

    
    //commits? YES
    void removeAnOrderByDate(){
        boolean editing = false;
        view.displayRemoveAnOrderBanner();
        
        LocalDate[] enteredDateInfo = view.askForDate(editing);
        try{
            List<Order> ordersForDate = orderService.getOrdersByDate(enteredDateInfo[0]); //use Exception inside for missing dates
            view.showAllOrdersForDate(ordersForDate, enteredDateInfo[0]);
            
            Integer orderNum = view.getOrderNumFromUser(); //input validation
            Order orderToRemove = orderService.getOrderByNumber(orderNum, enteredDateInfo[0]); //uses native checking
            
            boolean inLargeList = false;
            view.showInfoForOneOrder(orderToRemove, inLargeList);            
            
            boolean commit = view.askToCommit("Order will be removed.");
            if (commit){
                Order removedOrder = orderService.removeOrder(orderToRemove, enteredDateInfo[0]); //get the orderNum later in dao for actual removal
                view.displayOperationSuccessfulMessage("Remove Order");
            } else {
                view.displayOperationAbandonedMessage("Remove Order");
            }
        } catch (FlooringPersistenceException ex){
            view.displayExceptionMessage("Error: Unable to load dates from file.");
        } catch (NullPointerException ex) {
            view.displayExceptionMessage("Error: No order(s) for that date.");
        }
    }
    
    //commits? YES
    void switchApplicationMode(){
        //this should begin the switch to other implementation(s)
        view.displaySwitchApplicationModeBanner();
        view.displayWarningAboutLosingCurrentWorkIfSwitchingMode();//"Note that if you change modes, the work you currently have will be lost
        
        boolean wantToSwitch=false;
        boolean commit=false;
        
        
        //(isTrainingMode) ? view.displayYouAreInTrainingMode() : view.displayYouAreInProductionMode();
        
        if (isTrainingMode){
            view.displayYouAreInTrainingMode(); //"You are in Training mode. This means that you cannot save your current work. If you want to be able to save work, switch to Production mode."
        } else {
            view.displayYouAreInProductionMode();//"You are currently in Production mode. If you want to practice using this program and not save your work, switch to Training mode."
        }
        
        wantToSwitch = view.askWantToSwitch();
        
        if (wantToSwitch){
            String doSwitch = "Switch Modes";
            commit = view.askToCommit("Warning: Any usaved changes will be lost.");
            if (commit){
                orderService.switchMode(isTrainingMode);
                isTrainingMode=!isTrainingMode;
                view.displayOperationSuccessfulMessage(doSwitch);
            } else{
                view.displayOperationAbandonedMessage(doSwitch);
            }
        }
    }
    
    public String returnModeString(boolean isTrainingMode) {
        if (isTrainingMode) {
            return "TRAINING MODE";
        } else {
            return "PRODUCTION MODE";
        }
    } 
}
