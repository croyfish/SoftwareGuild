/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.service.SightingService;
import com.sg.superherosightings.viewmodel.SightingViewModel;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jeffc
 */
@Controller
public class SightingController {

    @Inject
    SightingService sightingService;
    //many more beans required....

    public SightingController() {
    }

    // this is an arbitrary redirect based on the jsp ish
    @RequestMapping(value = "/sighting/sightings", method = RequestMethod.GET)
    public String displaySightingsPage(Model model, RedirectAttributes redirectAttrs) {

        List<SightingViewModel> svmList = sightingService.getSightingViewModels(0, 10);
        
        if (svmList.size() != 0) {
            Integer sightingClicked = svmList.get(0).getSighting().getSightingId();
            redirectAttrs.addAttribute("sightingClicked", sightingClicked);
            return "redirect:/sighting/chooseSighting?sightingClicked={sightingClicked}";
        }
        
        model.addAttribute("svmList", svmList);       
        // this is directory/file
        return "/sighting/sightings";
    }
    
    @RequestMapping(value = "sighting/chooseSighting", method = RequestMethod.GET)
    public String displaySightingsPageWithSelectedSighting(Model model, HttpServletRequest request, @RequestParam Integer sightingClicked) {
        
        //thinking getSightingViewModelBySightingId -- new method for sightingService
        SightingViewModel svm = sightingService.getSightingViewModelBySightingId(sightingClicked);        
        model.addAttribute("svm", svm);

        //when we redirect, how do we send new information to the model?
        List<SightingViewModel> svmList = sightingService.getSightingViewModels(0, 10);
        model.addAttribute("svmList", svmList);

        return "/sighting/sightings";
    }
    
    @RequestMapping(value = "sighting/delete_sighting", method = RequestMethod.GET)
    public String displayDeleteSightingPage(Model model, HttpServletRequest request, @RequestParam Integer sightingToDelete) {
        model.addAttribute("sightingToDelete", sightingToDelete);
        return "sighting/delete_sighting";
    }
    
    @RequestMapping(value = "sighting/deleteSighting", method = RequestMethod.POST)
    public String deleteSighting(@RequestParam(value="sightingToDelete") String sightingToDelete, Model model) {
        sightingService.deleteSighting(sightingService.getSightingById(Integer.parseInt(sightingToDelete)));
        return "redirect:/sighting/sightings";
    }

    @RequestMapping(value = "sighting/redirectToSightingsPage", method = RequestMethod.POST)
    public String redirectToSightingsPage(Model model) {

        return "redirect:/sighting/sightings";
    }
    
    
            
            
}
