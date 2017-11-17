/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.commandmodel.CreateSuperPersonCommandModel;
import com.sg.superherosightings.commandmodel.UpdateSuperPersonCommandModel;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
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
    public String createSuperPerson(@Valid @ModelAttribute("cspcm") CreateSuperPersonCommandModel cspcm,
            BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            model.addAttribute("powers", powerService.getAllPowers(0, Integer.MAX_VALUE));
            List<Organization> orgs = organizationService.getAllOrganizations(0, Integer.MAX_VALUE);
            model.addAttribute("organizations", orgs);
            return "superperson/create_superperson";
        }
        
        SuperPerson superPersonToCreate = superPersonService.buildSuperPersonFromCommandModel(cspcm);
        SuperPerson createdSuperPerson = superPersonService.createSuperPerson(superPersonToCreate);
        superPersonService.addSuperPersonToPowers(createdSuperPerson.getSuperPersonId(), cspcm.getPowers());
        superPersonService.addSuperPersonToOrganizations(createdSuperPerson.getSuperPersonId(), cspcm.getOrganizations());
        return "redirect:/superperson/superpersons";
    }

    @RequestMapping(value = "superperson/displayUpdateSuperPersonPage", method = RequestMethod.GET)
    public String displayUpdateSuperPersonPage(Model model, HttpServletRequest request, @RequestParam Integer superPersonToUpdate) {
        SuperPersonViewModel spvm2 = superPersonService.getSuperPersonViewModelBySuperPersonId(superPersonToUpdate);
        List<Power> allPowers = powerService.getAllPowers(0, Integer.MAX_VALUE);
        List<Power> hasPowers = powerService.getAllPowersBySuperPerson(spvm2.getSuperPerson(), 0, Integer.MAX_VALUE);
        List<Power> doesntHavePowers = allPowers;
        for (Power currentPower : hasPowers) {
            doesntHavePowers.remove(currentPower);
        }

        List<Organization> allOrganizations = organizationService.getAllOrganizations(0, Integer.MAX_VALUE);
        List<Organization> hasOrganizations = organizationService.getAllOrganizationsBySuperPerson(spvm2.getSuperPerson(), 0, Integer.MAX_VALUE);
        List<Organization> doesntHaveOrganizations = allOrganizations;
        for (Organization currentOrganization : hasOrganizations) {
            doesntHaveOrganizations.remove(currentOrganization);
        }

        SuperPersonViewModel spvm = new SuperPersonViewModel();
        spvm.setPowers(powerService.getAllPowers(0, Integer.MAX_VALUE));
        spvm.setOrganizations(organizationService.getAllOrganizations(0, Integer.MAX_VALUE));
        model.addAttribute("spvm", spvm);
        model.addAttribute("spvm2", spvm2);
        model.addAttribute("doesntHavePowers", doesntHavePowers);
        model.addAttribute("doesntHaveOrganizations", doesntHaveOrganizations);
        return "superperson/update_superperson";
    }

    @RequestMapping(value = "superperson/updateSuperPerson", method = RequestMethod.POST)
    public String updateSuperPerson(@Valid @ModelAttribute("uspcm") UpdateSuperPersonCommandModel uspcm,
            BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            model.addAttribute("power", powerService.getAllPowers(0, Integer.MAX_VALUE));
            List<SuperPerson> orgs = superPersonService.getAllSuperPersons(0, Integer.MAX_VALUE);
            model.addAttribute("organizations", orgs);
            return "superperson/update_superperson";
        }        
        

        Integer idForUpdate = uspcm.getSuperPersonId();
        SuperPerson oldSp = superPersonService.getSuperPersonById(idForUpdate);
        
        List<Power> oldPowers = powerService.getAllPowersBySuperPerson(oldSp, 0, Integer.MAX_VALUE);
        for (Power currentPower : oldPowers) {
            superPersonService.deletePowerFromSuperPerson(oldSp, currentPower);
        }

        List<Organization> oldOrganizations = organizationService.getAllOrganizationsBySuperPerson(oldSp, 0, Integer.MAX_VALUE);
        for (Organization currentOrganization : oldOrganizations) {
            superPersonService.deleteOrganizationFromSuperPerson(oldSp, currentOrganization);
        }

        SuperPerson updatedSuperPerson = new SuperPerson();
        updatedSuperPerson.setName(uspcm.getName());
        updatedSuperPerson.setDescription(uspcm.getDescription());
        updatedSuperPerson.setSuperPersonId(uspcm.getSuperPersonId());
        String reputation = uspcm.getReputation();

        if (reputation.equals("good")) {
            updatedSuperPerson.setIsGood(true);
        } else if (reputation.equals("evil")) {
            updatedSuperPerson.setIsGood(false);
        }

        Integer[] powers = uspcm.getPowers();
        Integer[] orgs = uspcm.getOrganizations();
        updatedSuperPerson = superPersonService.updateSuperPerson(updatedSuperPerson);
        
        for (Integer currentPower : powers) {
            superPersonService.addSuperPersonToPower(updatedSuperPerson,
                    powerService.getPowerById(currentPower));
        }
        for (Integer currentOrg : orgs) {
            superPersonService.addSuperPersonToOrganization(updatedSuperPerson,
                    organizationService.getOrganizationById(currentOrg));
        }

        return "redirect:/superperson/superpersons";
    }
    
    
    
}
