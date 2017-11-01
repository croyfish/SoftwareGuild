/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.commandmodel.SightingCommandModel;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.service.LocationService;
import com.sg.superherosightings.service.SightingService;
import com.sg.superherosightings.service.SuperPersonService;
import com.sg.superherosightings.viewmodel.SightingViewModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    @Inject
    SuperPersonService superPersonService;

    @Inject
    LocationService locationService;

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
    public String deleteSighting(@RequestParam(value = "sightingToDelete") String sightingToDelete, Model model) {
        sightingService.deleteSighting(sightingService.getSightingById(Integer.parseInt(sightingToDelete)));
        return "redirect:/sighting/sightings";
    }

    @RequestMapping(value = "sighting/redirectToSightingsPage", method = RequestMethod.POST)
    public String redirectToSightingsPage(Model model) {
        return "redirect:/sighting/sightings";
    }

    @RequestMapping(value = "sighting/displayCreateSightingPage", method = RequestMethod.POST)
    public String displayCreateSightingPage(Model model) {
        model.addAttribute("locations", locationService.getAllLocations(0, Integer.MAX_VALUE));
        List<SuperPerson> sps = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
        model.addAttribute("superPersons", sps);
        return "sighting/create_sighting";
    }

    @RequestMapping(value = "sighting/createSighting", method = RequestMethod.POST)
    public String createSighting(@Valid @ModelAttribute("scm") SightingCommandModel scm,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("locations", locationService.getAllLocations(0, Integer.MAX_VALUE));
            List<SuperPerson> sps = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
            model.addAttribute("superPersons", sps);
            return "sighting/create_sighting";
        }

        Location sightingLocation = locationService.getLocationById(scm.getLocationId());

        Sighting sightingToCreate = new Sighting();

        sightingToCreate.setDate(LocalDate.parse(scm.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        sightingToCreate.setDescription(scm.getDescription());
        sightingToCreate.setLocation(sightingLocation);

        Sighting createdSighting = sightingService.createSighting(sightingToCreate);

        for (Integer superPersonId : scm.getSuperPersons()) {
            superPersonService.addSuperPersonToSighting(superPersonId, createdSighting.getSightingId());
        }

        return "redirect:/sighting/sightings";
    }

@RequestMapping(value = "sighting/displayUpdateSightingPage", method = RequestMethod.GET)
    public String displayUpdateSightingPage(Model model, HttpServletRequest request, @RequestParam Integer sightingToUpdate) {
        
        SightingViewModel svm = sightingService.getSightingViewModelBySightingId(sightingToUpdate);
        model.addAttribute("svm", svm);
        
        model.addAttribute("sightingToUpdate", sightingToUpdate);

        List<SuperPerson> allSuperPersons = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
        model.addAttribute("allSuperPersons", allSuperPersons);

        List<Location> allLocations = locationService.getAllLocations(0, Integer.MAX_VALUE);
        model.addAttribute("allLocations", allLocations);

        return "sighting/update_sighting";
    }

    @RequestMapping(value = "sighting/updateSighting", method = RequestMethod.POST)
    public String updateSighting(@Valid @ModelAttribute("scm") SightingCommandModel scm,
            BindingResult result, Model model, HttpServletRequest request, @RequestParam Integer sightingToUpdate) {

        if (result.hasErrors()) {
            model.addAttribute("allLocations", locationService.getAllLocations(0, Integer.MAX_VALUE));
            List<SuperPerson> sps = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
            model.addAttribute("allSuperPersons", sps);
            SightingViewModel svm = sightingService.getSightingViewModelBySightingId(sightingToUpdate);
            model.addAttribute("svm", svm);
            LocalDate currentDate = svm.getSighting().getDate();
            String htmlDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            model.addAttribute("htmlDate", htmlDate);
            model.addAttribute("sightingToUpdate", sightingToUpdate);
            return "sighting/update_sighting";
        }

        Integer idForUpdate = scm.getSightingId();
        Sighting sightingToBeUpdated = sightingService.getSightingById(idForUpdate);

        //but should this go before or after the service update method?
        //need to reset the associations btw the org and its superpersons
        //1. get all the superpersons originally on the dto
        SightingViewModel svm = sightingService.getSightingViewModelBySightingId(idForUpdate);
        List<SuperPerson> originalSuperPersons = svm.getSuperPersons();
        //2. remove associations with super persons
        for (SuperPerson currentSp : originalSuperPersons) {
            superPersonService.deleteSightingFromSuperPerson(currentSp.getSuperPersonId(), idForUpdate);
        }
        //3. add new assocations with super persons
        Integer[] newSuperPersons = scm.getSuperPersons();
        for (Integer currentId : newSuperPersons) {
            superPersonService.addSuperPersonToSighting(currentId, idForUpdate);
        }

        Location sightingLocation = locationService.getLocationById(scm.getLocationId());
        
        sightingToBeUpdated.setLocation(sightingLocation);
        sightingToBeUpdated.setDescription(scm.getDescription());
        sightingToBeUpdated.setDate(LocalDate.parse(scm.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Sighting updatedSighting = sightingService.updateSighting(sightingToBeUpdated);

        return "redirect:/sighting/sightings";
    }    
    
}
