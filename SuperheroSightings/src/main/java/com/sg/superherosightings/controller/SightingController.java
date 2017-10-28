/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.service.SightingService;
import com.sg.superherosightings.viewmodel.SightingViewModel;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String displaySightingsPage(Model model) {

        List<SightingViewModel> svmList = sightingService.getSightingViewModels(0, 10);
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
}
