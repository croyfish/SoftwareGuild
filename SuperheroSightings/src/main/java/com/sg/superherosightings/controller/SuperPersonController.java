/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.service.OrganizationService;
import com.sg.superherosightings.service.PowerService;
import com.sg.superherosightings.service.SuperPersonService;
import com.sg.superherosightings.viewmodel.SuperPersonViewModel;
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
public class SuperPersonController {

    @Inject
    SuperPersonService superPersonService;
    @Inject
    PowerService powerService;
    @Inject
    OrganizationService organizationService;

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
    public String deleteSuperPerson(@RequestParam(value = "superPersonToDelete") String superPersonToDelete, Model model) {
        superPersonService.deleteSuperPerson(superPersonService.getSuperPersonById(Integer.parseInt(superPersonToDelete)));
        return "redirect:/superperson/superpersons";
    }

    @RequestMapping(value = "superperson/redirectToSuperPersonsPage", method = RequestMethod.POST)
    public String redirectToSuperPersonsPage(Model model) {

        return "redirect:/superperson/superpersons";
    }

    @RequestMapping(value = "superperson/displayCreateSuperPersonPage", method = RequestMethod.POST)
    public String displayCreateSuperPersonPage(Model model) {
        SuperPersonViewModel spvm = new SuperPersonViewModel();

        spvm.setPowers(powerService.getAllPowers(0, Integer.MAX_VALUE));
        spvm.setOrganizations(organizationService.getAllOrganizations(0, Integer.MAX_VALUE));
        model.addAttribute("spvm", spvm);

        return "superperson/create_superperson";
    }

    @RequestMapping(value = "superperson/createSuperPerson", method = RequestMethod.POST)
    public String createSuperPerson(Model model, HttpServletRequest request) {

        SuperPerson newSuperPerson = new SuperPerson();
        newSuperPerson.setName(request.getParameter("name"));
        newSuperPerson.setDescription(request.getParameter("description"));
        String reputation = request.getParameter("reputation");

        if (reputation != null) {
            if (reputation.equals("good")) {
                newSuperPerson.setIsGood(true);
            } else if (reputation.equals("evil")) {
                newSuperPerson.setIsGood(false);
            }
        }

        model.addAttribute(newSuperPerson);

        String[] powers = request.getParameterValues("powers");
        String[] orgs = request.getParameterValues("organizations");
        model.addAttribute(powers);
        model.addAttribute(orgs);

        return "redirect:/superperson/createSuperPersonValidation";

    }

    @RequestMapping(value = "superperson/createSuperPersonValidation", method = RequestMethod.POST)
    public String createSuperPersonValidation(@Valid @ModelAttribute("superPerson") SuperPerson newSuperPerson, BindingResult result,
            @ModelAttribute("powers") String[] powers,
            @ModelAttribute("orgs") String[] orgs) {

        if (result.hasErrors()) {
            return "superperson/displayCreateSuperPersonPage";
        }

        newSuperPerson = superPersonService.createSuperPerson(newSuperPerson);

        for (String currentPower : powers) {
            superPersonService.addSuperPersonToPower(newSuperPerson,
                    powerService.getPowerById(Integer.parseInt(currentPower)));
        }

        for (String currentOrg : orgs) {
            superPersonService.addSuperPersonToOrganization(newSuperPerson,
                    organizationService.getOrganizationById(Integer.parseInt(currentOrg)));
        }

        return "redirect:/superperson/superpersons";

    }

}
