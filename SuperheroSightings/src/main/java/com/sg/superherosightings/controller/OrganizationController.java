/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.service.OrganizationService;
import com.sg.superherosightings.viewmodel.OrganizationViewModel;
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
public class OrganizationController {

    @Inject
    OrganizationService organizationService;
    //many more beans required....

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

    @RequestMapping(value = "organization/delete_organization", method = RequestMethod.GET)
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

}
