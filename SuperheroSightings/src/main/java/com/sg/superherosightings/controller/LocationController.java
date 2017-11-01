/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.commandmodel.CreateLocationCommandModel;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.service.AddressService;
import com.sg.superherosightings.service.LocationService;
import com.sg.superherosightings.viewmodel.LocationViewModel;
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
public class LocationController {

    @Inject
    LocationService locationService;
    
    @Inject
    AddressService addressService;

    public LocationController() {
    }

    @RequestMapping(value = "/location/locations", method = RequestMethod.GET)
    public String displayLocationsPage(Model model, RedirectAttributes redirectAttrs) {
        List<LocationViewModel> lvmList = locationService.getLocationViewModels(0, 10);

        if (lvmList.size() != 0) {
            Integer locationClicked = lvmList.get(0).getLocation().getLocationId();
            redirectAttrs.addAttribute("locationClicked", locationClicked);
            return "redirect:/location/chooseLocation?locationClicked={locationClicked}";
        }

        model.addAttribute("lvmList", lvmList);

        return "/location/locations";
    }

    @RequestMapping(value = "/location/chooseLocation", method = RequestMethod.GET)
    public String displayLocationsPageWithSelectedLocation(Model model, HttpServletRequest request, @RequestParam Integer locationClicked) {
        LocationViewModel lvm = locationService.getLocationViewModelByLocationId(locationClicked);
        model.addAttribute("lvm", lvm);

        List<LocationViewModel> lvmList = locationService.getLocationViewModels(0, 10);
        model.addAttribute("lvmList", lvmList);

        return "/location/locations";
    }

    @RequestMapping(value = "location/displayCreateLocationPage", method = RequestMethod.GET)
    public String displayCreateLocationPage(Model model) {

        return "location/create_location";
    }
    
 @RequestMapping(value = "location/createLocation", method = RequestMethod.POST)
    public String createLocation(@Valid @ModelAttribute("clcm") CreateLocationCommandModel clcm,
            BindingResult result) {

        if (result.hasErrors()) {
            return "location/create_location";
        }

        
        Address newAddress = new Address();
        
        newAddress.setCity(clcm.getCity());
        newAddress.setState(clcm.getState());
        newAddress.setStreet(clcm.getStreet());
        newAddress.setZipcode(clcm.getZipcode());
        
        Address createdAddress = addressService.createAddress(newAddress);
        
        Location newLocation = new Location();
        
        newLocation.setAddress(createdAddress);
        newLocation.setDescription(clcm.getDescription());
        newLocation.setLatitude(clcm.getLatitude());
        newLocation.setLongitude(clcm.getLongitude());
        newLocation.setName(clcm.getName());
        
        Location createdLocation = locationService.createLocation(newLocation);

        return "redirect:/location/locations";
    }
    
    
}
