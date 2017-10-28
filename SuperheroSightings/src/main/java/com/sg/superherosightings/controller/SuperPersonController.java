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
    public String displaySuperPersonsPage(Model model) {

        List<SuperPersonViewModel> spvmList = superPersonService.getSuperPersonViewModels(0, 10);
        //will we need a count method to help us with the paging?
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
}
