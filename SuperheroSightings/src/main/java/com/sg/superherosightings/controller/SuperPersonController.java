/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.service.SuperPersonService;
import com.sg.superherosightings.viewmodel.SuperPersonViewModel;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jeffc
 */
@Controller
public class SuperPersonController {
    @Inject
    SuperPersonService superPersonService;

    public SuperPersonController() {
    }

    @RequestMapping(value = "/superperson/superpersons", method = RequestMethod.GET)
    public String displaySuperPersonsPage(Model model, RedirectAttributes redirectAttrs) {

        List<SuperPersonViewModel> spvmList = superPersonService.getSuperPersonViewModels(0, 10);

        if (spvmList.size() != 0) {
            Integer superPersonClicked = spvmList.get(0).getSuperPerson().getSuperPersonId();
            redirectAttrs.addAttribute("superPersonClicked", superPersonClicked);
            return "redirect:/superperson/chooseSuperPerson?superPersonClicked={superPersonClicked}";
        }        
        
        
        model.addAttribute("spvmList", spvmList);

        return "/superperson/superpersons";
    }
    
    @RequestMapping(value = "/superperson/chooseSuperPerson", method = RequestMethod.GET)
    public String displaySuperPersonsPageWithSelectedSuperPerson(Model model, HttpServletRequest request, @RequestParam Integer superPersonClicked) {
        //thinking getSuperPersonViewModelBySuperPersonId -- new method for superpersonService
        SuperPersonViewModel spvm = superPersonService.getSuperPersonViewModelBySuperPersonId(superPersonClicked);        
        model.addAttribute("spvm", spvm);

        List<SuperPersonViewModel> spvmList = superPersonService.getSuperPersonViewModels(0, 10);
        model.addAttribute("spvmList", spvmList);
        
        return "/superperson/superpersons";
    }
    
    @RequestMapping(value = "superperson/delete_superperson", method = RequestMethod.GET)
    public String displayDeleteSuperPersonPage(Model model, HttpServletRequest request, @RequestParam Integer superPersonToDelete) {
        model.addAttribute("superPersonToDelete", superPersonToDelete);
        return "superperson/delete_superperson";
    }
    
    @RequestMapping(value = "superperson/deleteSuperPerson", method = RequestMethod.POST)
    public String deleteSuperPerson(@RequestParam(value="superPersonToDelete") String superPersonToDelete, Model model) {
        superPersonService.deleteSuperPerson(superPersonService.getSuperPersonById(Integer.parseInt(superPersonToDelete)));
        return "redirect:/superperson/superpersons";
    }

    @RequestMapping(value = "superperson/redirectToSuperPersonsPage", method = RequestMethod.POST)
    public String redirectToSuperPersonsPage(Model model) {

        return "redirect:/superperson/superpersons";
    }

    @RequestMapping(value = "/displayCreateSuperPersonPage", method = RequestMethod.GET)
    public String displayCreateSuperPersonPage(Model model) {
        SuperPersonViewModel spvm = new SuperPersonViewModel();
        
        
        return "superperson/create_superperson";
    }
    
    @RequestMapping(value = "superperson/deleteSuperPerson", method = RequestMethod.POST)
    public String createSuperPerson(@RequestParam(value="superPersonToDelete") String superPersonToDelete, Model model) {
        superPersonService.deleteSuperPerson(superPersonService.getSuperPersonById(Integer.parseInt(superPersonToDelete)));
        return "redirect:/superperson/superpersons";
    }



    
}
