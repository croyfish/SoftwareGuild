/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.controller;

import com.sg.vendingmachinespringmvc2.model.Change;
import com.sg.vendingmachinespringmvc2.model.Item;
import com.sg.vendingmachinespringmvc2.model.Selection;
import com.sg.vendingmachinespringmvc2.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinespringmvc2.service.VendingMachineItemNotInStockException;
import com.sg.vendingmachinespringmvc2.service.VendingMachineItemService;
import com.sg.vendingmachinespringmvc2.service.VendingMachineMachineChangeService;
import com.sg.vendingmachinespringmvc2.service.VendingMachineSelectionService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sg.vendingmachinespringmvc2.service.VendingMachineUserChangeService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jeffc
 */
@Controller
public class VendingMachineController {
    
    VendingMachineItemService itemService;
    VendingMachineSelectionService selectionService;
    VendingMachineUserChangeService userChangeService;
    VendingMachineMachineChangeService machineChangeService;
    
    public String changeToReturn = "(no change)";
    public String selectionString = "(no selection)";
    public String messages = "(no messages)";

    
    @Inject
    public VendingMachineController(VendingMachineItemService itemService,
            VendingMachineSelectionService selectionService,
            VendingMachineUserChangeService userChangeService, 
            VendingMachineMachineChangeService machineChangeService) {
        
        this.itemService = itemService;
        this.selectionService = selectionService;
        this.userChangeService = userChangeService;
        this.machineChangeService = machineChangeService;
    }
    
    
//    @RequestMapping(value="/getMoneyEntered", method=RequestMethod.GET)
//    public String moneyEntered(Model model) {
//        Change moneyEntered = machineChangeService.getChange();
//        model.addAttribute("moneyEntered", moneyEntered);
//        return "redirect:displayVendingMachine";
//    }

    @RequestMapping(value="/getChange", method=RequestMethod.GET)
    public String getChange(Model model) {
        
        Change userMoney = userChangeService.getChange();
        returnChange(userMoney);
        
        return "redirect:displayVendingMachine";
    }
    
    public void returnChange(Change change) {
        
        userChangeService.removeChange();
        BigDecimal changeBD = change.getValueOfChange();
        Change changeReturned = calculateChange(changeBD);
        
        setStringValueOfChange(changeReturned);
    }
    
    @RequestMapping(value="/selectItem", method=RequestMethod.POST)
    public String requestItem(@RequestParam(value="item") String item, 
            Model model) {
        
        Selection selection = new Selection();
        selection.setSelection(Long.parseLong(item));
        
        selectionService.select(selection);
        
        this.selectionString = item;
        
//        playSound("select");
        
        return "redirect:displayVendingMachine";
        
    }
    
    @RequestMapping(value="/addUserMoney", method=RequestMethod.POST)
    public String addUserMoney(@RequestParam(value="button") String button,
		Model model) {
        
        Change change = new Change();
        
        if (button.equals("Add Dollar")) {
            change.setDollars(1);          
        }
        if (button.equals("Add Quarter")) {
            change.setQuarters(1);
        }
        if (button.equals("Add Dime")) {
            change.setDimes(1);
        }
        if (button.equals("Add Nickel")) {
            change.setNickels(1);
        }        
        
        userChangeService.addChange(change);
        
        return "redirect:displayVendingMachine";
    }

    @RequestMapping(value="/displayVendingMachine", method=RequestMethod.GET)
    public String displayVendingMachine(Model model) {

        List<Item> itemList = itemService.getAllItems();
        model.addAttribute("itemList", itemList);        
//        String button = "";
//        model.addAttribute("button", button);
        String moneyEntered = userChangeService.getChange().getValueOfChange().toString();
        model.addAttribute("moneyEntered", moneyEntered);
        
        model.addAttribute("messages", messages);
        
        model.addAttribute("selectionString", selectionString);
        
        model.addAttribute("changeToReturn", changeToReturn);
        return "vending-machine";
    }
    
    @RequestMapping(value="/purchaseItem", method=RequestMethod.GET)
    public String purchaseItem(Model model) {
        
        Selection currentSelection = selectionService.getSelection();
        Long currentSelectionLong = currentSelection.getSelection();
        Item purchasedItem = itemService.getItemById(currentSelectionLong);
        
        Change moneyEntered = userChangeService.getChange();
        BigDecimal moneyEnteredBD = moneyEntered.getValueOfChange();
        BigDecimal costOfItem = purchasedItem.getPrice();
        
        try {
            itemService.makePurchase(moneyEnteredBD, purchasedItem);
            this.messages = "Thank you!!! Please click on your change below.";
            machineChangeService.addChange(moneyEntered);
            BigDecimal moneyReturned = moneyEnteredBD.subtract(costOfItem);
            Change changeDue = calculateChange(moneyReturned);
            machineChangeService.subtractChange(moneyEntered);
            returnChange(changeDue);
        } catch (VendingMachineItemNotInStockException e) {
            this.messages = "SOLD OUT!!!";
        } catch (VendingMachineInsufficientFundsException ex) {
            this.messages = "Please deposit: $" + (costOfItem.subtract(moneyEnteredBD).toString());
        }
         
        return "redirect:displayVendingMachine";
        
    }

    @RequestMapping(value="/getCurrentSelection", method=RequestMethod.GET)
    public String currentSelection(Model model) {
        Selection selection = selectionService.getSelection();
        model.addAttribute("selection", selection);
        return "redirect:displayVendingMachine";
    }
    
    @RequestMapping(value="/resetDisplay", method=RequestMethod.GET)
    public String resetDisplay(Model model) {
        
        this.messages = "(no messages)";
        this.selectionString = "(no selection)";
        this.changeToReturn = "(no change)";
        return "redirect:displayVendingMachine";
    }
    
    public Change calculateChange(BigDecimal money) {
        
        Change userChange = new Change();
        
        // Calculate number of quarters to return
        BigDecimal quarters = money.divide(new BigDecimal("0.25"));
        quarters = quarters.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(quarters.multiply(new BigDecimal("0.25")));
        userChange.setQuarters(quarters.intValue());
        
        // Calculate number of dimes to return
        BigDecimal dimes = money.divide(new BigDecimal("0.1"));
        dimes = dimes.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(dimes.multiply(new BigDecimal("0.1")));
        userChange.setDimes(dimes.intValue());
        
        // Calculate number of nickels to return
        BigDecimal nickels = money.divide(new BigDecimal("0.05"));
        nickels = nickels.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(nickels.multiply(new BigDecimal("0.05")));
        userChange.setNickels(nickels.intValue());
        
        // Calculate number of pennies to return
        BigDecimal pennies = money.divide(new BigDecimal("0.01"));
        pennies = pennies.setScale(0, RoundingMode.FLOOR);
        money = money.subtract(pennies.multiply(new BigDecimal("0.01")));
        userChange.setPennies(pennies.intValue());
        
        // Return user's change object
        return userChange;    
    }
    
    public void setStringValueOfChange(Change change) {
        
        String changeReturned = "";
        
        if (change.getQuarters() != 0) {
            changeReturned += change.getQuarters() + " Quarters  ";
        }
        if (change.getDimes() != 0L) {
            changeReturned += change.getDimes() + " Dimes  ";
        }
        if (change.getNickels() != 0L) {
            changeReturned += change.getNickels() + " Nickels  ";
        }        
        if (change.getPennies() != 0L) {
            changeReturned += change.getPennies() + " Pennies  ";
        }
        if (changeReturned.equals("")) {
            changeReturned = "(no change)";
        }
        
        this.changeToReturn = changeReturned;
    }
    
//    public void playSound(String sound) {
//        String url = "C:\\audio\\" + sound + ".mp3";
//        Media hit = new Media(new File(url).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(hit);
//        mediaPlayer.play();
//    }
}
