/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class FlooringView {

    UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }

    public void displayDisplayOrdersBanner() {
        io.print("<<<<< Display Orders >>>>>");
    }

    public LocalDate[] askForDate(boolean editing) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //CHECK THIS IF PROBLEMATIC
        LocalDate dates[] = new LocalDate[2];
        LocalDate oldDate = io.readLocalDate("Enter the full date as yyyy-MM-dd: ");
        dates[0] = oldDate;
        if (editing) {
            boolean isDateValid = false;
            while (!isDateValid) {

                String newDate = io.readString("Enter the new order date as yyyy-MM-dd (press ENTER keep the original date): ");
                if (newDate.equals("")) {
                    dates[1] = oldDate;
                    isDateValid = true;
                } else {
                    try {
                        LocalDate oldLocalDate = LocalDate.parse(newDate, formatter);
                        isDateValid = true;
                    } catch (DateTimeParseException e) {
                        io.print("Please enter a valid date as yyyy-MM-dd");
                    }
                }

            }
        }
        return dates;
    }

    public void displayAddAnOrderBanner() {
        io.print("<<<<< Add an Order >>>>>");
    }

    public void displayOpeningPage() {
        io.print("");
        io.print("");
        io.print("Welcome to the Flooring Mastery Project (TM)!");
    }

    public void waitForEnter() {
        io.readString("Press ENTER to Continue");
    }

    public void printInvalidChoiceMessage() {
        io.print("Your selection is not valid.");
    }

    public boolean askToCommit(String warningMessage) {
        String userAnswer = io.readString(warningMessage + " Are you sure you want to do this? (y/n)");
        return userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes");
    }

    public int printActionMenuAndGetSelection(String mode) {
        io.print("=========================================");
        io.print("<<<<<<<<<<<<< Flooring Menu >>>>>>>>>>>>>");
        io.print("=========================================");
        io.print("1. Show all orders for a specific date");
        io.print("2. Add an order");
        io.print("3. Edit an order");
        io.print("4. Remove an order");
        io.print("5. Change modes (currently in " + mode + ")");
        io.print("6. Quit");
        //io.print("7. Enter Admin Mode");
        io.print("");
        int userSelection = io.readInt("Please enter your selection: ", 1, 6);
        io.print("=========================================");
        io.print("=========================================");
        return userSelection;
    }

    public void displayEditAnOrderBanner() {
        io.print("<<<<< Edit an Order >>>>>");
    }

    public Integer getOrderNumFromUser() {
        return io.readInt("Which order number would you like to select? ");
    }

    //maybe combine to one method -- get info from user
    public Order setBasicOrderInfoForEdit(Order order, boolean editing) {

        String oldName = order.getCustomerName();
        String oldNameMessage = "(" + oldName + ")";
        BigDecimal oldFlooringArea = order.getFlooringArea();
        String oldFlooringAreaMessage = "(" + oldFlooringArea + ")";
        String oldState = order.getState();
        String oldStateMessage = "(" + oldState + ")";
        String oldProductType = order.getProductType();
        String oldProductTypeMessage = "(" + oldProductType + ")";

        String customerName = io.readString("Customer name: " + (editing ? oldNameMessage : "") + ": ");
        if (customerName.equals("")) {
            customerName = order.getCustomerName();
        }
        String productType = io.readString("Product type: " + (editing ? oldProductTypeMessage : "") + ": ");
        if (productType.equals("")) {
            productType = order.getProductType();
        }

        BigDecimal flooringAreaBD = null;
        boolean flooringAreaIsValid = false;
        while (!flooringAreaIsValid) {
            String flooringArea = io.readString("Flooring area (sq ft.): " + (editing ? oldFlooringAreaMessage : "") + ": "); //not sure about this one....

            if (flooringArea.equals("")) {
                flooringAreaBD = order.getFlooringArea();
                flooringAreaIsValid = true;
            } else {
                try {
                    flooringAreaBD = new BigDecimal(flooringArea);
                    if (flooringAreaBD.compareTo(new BigDecimal("0")) == 1) {
                        flooringAreaIsValid = true;
                    } else {
                        displayExceptionMessage("Error: Flooring area must be greater than 0.");
                    }
                } catch (NumberFormatException e) {
                    io.print("That flooring area is invalid. Please enter a valid number.");
                    waitForEnter();
                }
            }
        }

        String state = io.readString("Customer's state of residence: " + (editing ? oldStateMessage : "") + ": ");
        if (state.equals("")) {
            state = order.getState();
        }

        order.setCustomerName(customerName);
        order.setProductType(productType);
        order.setFlooringArea(flooringAreaBD);
        order.setState(state);

        return order;

    }

    public Order setBasicOrderInfoForAdd(Order order, boolean editing) {

        boolean inputIsValid = false;

        String customerName = null;
        while (!inputIsValid) {
            customerName = io.readString("Customer name: ");
            if (!customerName.equals("")) {
                inputIsValid = true;
            } else {
                displayExceptionMessage("Error: Cannot leave name blank.");
            }
        }

        inputIsValid = false;

        String productType = null;
        while (!inputIsValid) {
            productType = io.readString("Product type: ");
            if (!productType.equals("")) {
                inputIsValid = true;
            } else {
                displayExceptionMessage("Error: Cannot leave product type blank.");
            }
        }

        BigDecimal flooringAreaBD = null;
        boolean flooringAreaIsValid = false;
        while (!flooringAreaIsValid) {
            String flooringArea = io.readString("Flooring area (sq ft.): "); //not sure about this one....

            if (flooringArea.equals("")) {
                flooringAreaBD = order.getFlooringArea();
                flooringAreaIsValid = true;
            } else {
                try {
                    flooringAreaBD = new BigDecimal(flooringArea);
                    if (flooringAreaBD.compareTo(new BigDecimal("0")) == 1) {
                        flooringAreaIsValid = true;
                    } else {
                        displayExceptionMessage("Error: Flooring area must be greater than 0.");
                    }
                } catch (NumberFormatException e) {
                    io.print("Please enter a valid number.");
                    waitForEnter();
                }
            }
        }

        inputIsValid = false;

        String state = null;
        while (!inputIsValid) {
            state = io.readString("Customer's state of residence (two letters): ");
            if (!state.equals("")) {
                inputIsValid = true;
            } else {
                displayExceptionMessage("Error: Cannot leave state blank.");
            }
        }

        order.setCustomerName(customerName);
        order.setProductType(productType);
        order.setFlooringArea(flooringAreaBD);
        order.setState(state);

        return order;

    }

    public void displayRemoveAnOrderBanner() {
        io.print("<<<<< Remove an Order >>>>>");
        waitForEnter();
    }

    public String displayCurrencyFormat(BigDecimal currency) {
        return NumberFormat.getCurrencyInstance().format(currency);
    }

    //maybe make a boolean that would only show some of these if it is being used in a list
    public void showInfoForOneOrder(Order fullyEditedOrder, boolean inLargeList) {
        //maybe push all these into a hashmap

        String[] infoStrings = {
            "Info for order #" + fullyEditedOrder.getOrderNumber(), //
            "=============================", //
            "Customer name: " + fullyEditedOrder.getCustomerName(), //
            "Customer state: " + fullyEditedOrder.getState(), //
            "Tax rate: " + fullyEditedOrder.getTaxRate() + "%",
            "=============================",
            "Product type: " + fullyEditedOrder.getProductType(), //
            "Flooring area (sq ft.): " + fullyEditedOrder.getFlooringArea(), //
            "=============================",
            "Material cost per sq ft.: " + displayCurrencyFormat(fullyEditedOrder.getCostPerSqFt()),
            "Labor cost per sq ft.: " + displayCurrencyFormat(fullyEditedOrder.getLaborCostPerSqFt()),
            "Total cost for materials: " + displayCurrencyFormat(fullyEditedOrder.getMaterialCost()),
            "Total cost for labor: " + displayCurrencyFormat(fullyEditedOrder.getLaborCost()),
            "Total tax: " + displayCurrencyFormat(fullyEditedOrder.getTotalTax()),
            "=============================",
            "Grand total: " + displayCurrencyFormat(fullyEditedOrder.getTotalCost()) //
        };
        
        if (inLargeList) {
            io.print(infoStrings[0]);
            io.print(infoStrings[1]);
            io.print(infoStrings[2]);
            io.print(infoStrings[3]);
            io.print(infoStrings[6]);
            io.print(infoStrings[7]);
            io.print(infoStrings[15]);
        } else {
            for (String info : infoStrings) {
                io.print(info);
            }
        }

        waitForEnter();
    }

    public void showAllOrdersForDate(List<Order> listOfOrders, LocalDate date) {
        boolean inLargeList = true;
        io.print("All orders for " + date + ": ");
        waitForEnter();
        for (Order currentOrder : listOfOrders) {
            showInfoForOneOrder(currentOrder, inLargeList);
        }
        if (listOfOrders.size() == 0) {
            io.print("Error: no orders found for the date you entered!!!");
        }
    }

    public void displaySwitchApplicationModeBanner() {
        io.print("<<<<< Change Modes >>>>>");
        waitForEnter();
    }

    public void displayYouAreInTrainingMode() {
        io.print("");
        io.print("You are currently in TRAINING MODE.");
    }

    public void displayYouAreInProductionMode() {
        io.print("");
        io.print("You are currently in PRODUCTION MODE.");
    }

    public void displayWarningAboutLosingCurrentWorkIfSwitchingMode() {
        io.print("Warning: If you change modes, your unsaved changes will be lost.");
        waitForEnter();
    }

    public boolean askWantToSwitch() {
        String userAnswer = io.readString("Would you like to change modes? (y/n) ");
        return userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes");
    }

    public void displayOperationSuccessfulMessage(String successfulOperation) {
        io.print("Your " + successfulOperation + " operation was successful. Returning to main menu.");
        waitForEnter();
    }

    public void displayOperationAbandonedMessage(String abandonedOperation) {
        io.print("Your " + abandonedOperation + " operation has been abandoned. Returning to main menu.");
        waitForEnter();
    }

    public void displayExceptionMessage(String string) {
        io.print(string);
        waitForEnter();
    }
}
