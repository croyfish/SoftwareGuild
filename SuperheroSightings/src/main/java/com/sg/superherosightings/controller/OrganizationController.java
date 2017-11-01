/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.commandmodel.OrganizationCommandModel;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.service.LocationService;
import com.sg.superherosightings.service.OrganizationService;
import com.sg.superherosightings.service.SuperPersonService;
import com.sg.superherosightings.viewmodel.OrganizationViewModel;
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
public class OrganizationController {

    @Inject
    OrganizationService organizationService;
    //many more beans required....
    @Inject
    SuperPersonService superPersonService;

    @Inject
    LocationService locationService;

    public OrganizationController() {
    }

    // this is an arbitrary redirect based on the jsp ish
    @RequestMapping(value = "organization/organizations", method = RequestMethod.GET)
    public String displaySightingsPage(Model model, RedirectAttributes redirectAttrs) {

        List<OrganizationViewModel> ovmList = organizationService.getOrganizationViewModels(0, 10);

        if (ovmList.size() != 0) {
            Integer organizationClicked = ovmList.get(0).getOrganization().getOrganizationId();
            redirectAttrs.addAttribute("organizationClicked", organizationClicked);
            return "redirect:/organization/chooseOrganization?organizationClicked={organizationClicked}";
        }

        model.addAttribute("ovmList", ovmList);

        // this is directory/file
        return "/organization/organizations";
    }

    @RequestMapping(value = "/organization/chooseOrganization", method = RequestMethod.GET)
    public String displayOrganizationsPageWithSelectedOrganization(Model model, HttpServletRequest request,
            @RequestParam Integer organizationClicked) {

        //thinking getSightingViewModelBySightingId -- new method for sightingService
        OrganizationViewModel ovm = organizationService.getOrganizationViewModelByOrganizationId(organizationClicked);
        model.addAttribute("ovm", ovm);

        //when we redirect, how do we send new information to the model?
        List<OrganizationViewModel> ovmList = organizationService.getOrganizationViewModels(0, 10);
        model.addAttribute("ovmList", ovmList);

        return "organization/organizations";
    }

    @RequestMapping(value = "organization/displayDeleteOrganizationPage", method = RequestMethod.GET)
    public String displayDeleteOrganizationPage(Model model, HttpServletRequest request,
            @RequestParam Integer organizationToDelete) {
        model.addAttribute("organizationToDelete", organizationToDelete);
        return "organization/delete_organization";
    }

    @RequestMapping(value = "organization/deleteOrganization", method = RequestMethod.POST)
    public String deleteOrganization(@RequestParam(value = "organizationToDelete") String organizationToDelete, Model model) {
        organizationService.deleteOrganization(organizationService.getOrganizationById(Integer.parseInt(organizationToDelete)));
        return "redirect:/organization/organizations";
    }

    @RequestMapping(value = "organization/redirectToOrganizationsPage", method = RequestMethod.POST)
    public String redirectToOrganizationsPage(Model model) {

        return "redirect:/organization/organizations";
    }

    @RequestMapping(value = "organization/displayCreateOrganization", method = RequestMethod.POST)
    public String displayCreateOrganizationPage(Model model) {

        model.addAttribute("locations", locationService.getAllLocations(0, Integer.MAX_VALUE));
        List<SuperPerson> sps = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
        model.addAttribute("superPersons", sps);

        return "organization/create_organization";
    }

    @RequestMapping(value = "organization/createOrganization", method = RequestMethod.POST)
    public String createOrganization(@Valid @ModelAttribute("ocm") OrganizationCommandModel ocm,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("locations", locationService.getAllLocations(0, Integer.MAX_VALUE));
            List<SuperPerson> sps = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
            model.addAttribute("superPersons", sps);
            return "organization/create_organization";
        }

        Organization organizationToCreate = new Organization();

        Location organizationLocation = locationService.getLocationById(ocm.getLocationId());
        organizationToCreate.setLocation(organizationLocation);

        organizationToCreate.setPhone(ocm.getPhone());
        organizationToCreate.setName(ocm.getName());
        organizationToCreate.setDescription(ocm.getDescription());

        String reputation = ocm.getIsGood();

        if (reputation == null) {
        } else if (reputation.equals("good")) {
            organizationToCreate.setIsGood(Boolean.TRUE);
        } else {
            organizationToCreate.setIsGood(Boolean.FALSE);
        }

        Organization createdOrganization = organizationService.createOrganization(organizationToCreate);
        for (Integer superPersonId : ocm.getSuperPersons()) {
            superPersonService.addSuperPersonToOrganization(superPersonId, createdOrganization.getOrganizationId());
        }
        return "redirect:/organization/organizations";
    }

    @RequestMapping(value = "organization/displayUpdateOrganizationPage", method = RequestMethod.GET)
    public String displayUpdateOrganizationPage(Model model, HttpServletRequest request, @RequestParam Integer organizationToUpdate) {
        OrganizationViewModel ovm = organizationService.getOrganizationViewModelByOrganizationId(organizationToUpdate);
        model.addAttribute("ovm", ovm);

        List<SuperPerson> allSuperPersons = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
        model.addAttribute("allSuperPersons", allSuperPersons);

        List<Location> allLocations = locationService.getAllLocations(0, Integer.MAX_VALUE);
        model.addAttribute("allLocations", allLocations);

        return "organization/update_organization";
    }

    @RequestMapping(value = "organization/updateOrganization", method = RequestMethod.POST)
    public String updateOrganization(@Valid @ModelAttribute("ocm") OrganizationCommandModel ocm,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("locations", locationService.getAllLocations(0, Integer.MAX_VALUE));
            List<SuperPerson> sps = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
            model.addAttribute("superPersons", sps);
            return "organization/update_organization";
        }

        Integer idForUpdate = ocm.getOrganizationId();
        Organization orgToUpdate = organizationService.getOrganizationById(idForUpdate);

        //but should this go before or after the service update method?
        //need to reset the associations btw the org and its superpersons
        //1. get all the superpersons originally on the dto
        OrganizationViewModel ovm = organizationService.getOrganizationViewModelByOrganizationId(idForUpdate);
        List<SuperPerson> originalSuperPersons = ovm.getSuperPersons();
        //2. remove associations with org
        for (SuperPerson currentSp : originalSuperPersons) {
            superPersonService.deleteOrganizationFromSuperPerson(currentSp.getSuperPersonId(), idForUpdate);
        }
        //3. add new assocations with org
        Integer[] newSuperPersons = ocm.getSuperPersons();
        for (Integer currentId : newSuperPersons) {
            superPersonService.addSuperPersonToOrganization(currentId, idForUpdate);
        }

        Location organizationLocation = locationService.getLocationById(ocm.getLocationId());
        orgToUpdate.setLocation(organizationLocation);

        orgToUpdate.setPhone(ocm.getPhone());
        orgToUpdate.setName(ocm.getName());
        orgToUpdate.setDescription(ocm.getDescription());

        String reputation = ocm.getIsGood();

        if (reputation == null) {
        } else if (reputation.equals("good")) {
            orgToUpdate.setIsGood(Boolean.TRUE);
        } else {
            orgToUpdate.setIsGood(Boolean.FALSE);
        }

        Organization updatedOrganization = organizationService.updateOrganization(orgToUpdate);

        return "redirect:/organization/organizations";
    }    
    
    
}
