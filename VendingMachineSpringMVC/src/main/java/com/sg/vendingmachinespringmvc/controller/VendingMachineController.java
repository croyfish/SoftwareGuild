/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.service.VendingMachineService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jeffc
 */
@Controller
public class VendingMachineController {
    
VendingMachineService service;
    
    // because controller is not tested! can use if only 1 impl in context...
    @Inject
    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }
    
//                      addMoney();
//                      purchaseItem();
//                      returnChange();
    
    @RequestMapping(value="/addMoney", method=RequestMethod.POST)
    public String addMoney(HttpServletRequest request) {
        
        Change moneyEntered = new Change();
        moneyEntered.setDollars(Integer.parseInt(request.getParameter("dollars")));
        moneyEntered.setQuarters(Integer.parseInt(request.getParameter("quarters")));
        moneyEntered.setDimes(Integer.parseInt(request.getParameter("dimes")));
        moneyEntered.setNickels(Integer.parseInt(request.getParameter("nickels")));
        
        service.addMoneyEnteredToDAO(moneyEntered);      
        
        return "index";
    }
    
//    @RequestMapping(value="/displayContactsPage", method=RequestMethod.GET)
//    public String displayContactsPage(Model model) {
//        // get all contacts
//        List<Contact> allContacts = dao.getAllContacts();
//        model.addAttribute("contactList", allContacts);
//
//        return "contacts";
//    }
//    
//    @RequestMapping(value="/createContact", method=RequestMethod.POST)
//    public String createContact(HttpServletRequest request) {
//        // create a new instance
//        Contact newContact = new Contact();
//        // set the properties based on form input
//        newContact.setFirstName(request.getParameter("firstName"));
//        newContact.setLastName(request.getParameter("lastName"));
//        newContact.setCompany(request.getParameter("company"));
//        newContact.setEmail(request.getParameter("email"));
//        newContact.setPhone(request.getParameter("phone"));
//        // save contact (persist)
//        dao.addContact(newContact);
//                
//        // redirect to contact page
//        return "redirect:displayContactsPage";
//    }
        
    
}
