/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.service.LocationService;
import com.sg.superherosightings.service.SightingService;
import com.sg.superherosightings.service.SuperPersonService;
import com.sg.superherosightings.viewmodel.SightingViewModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jeffc
 */
@Controller
public class HomeController {

    private SightingService sightingService;
    
    public HomeController(SightingService sightingService) {
         this.sightingService = sightingService;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String displayHomePage(Model model){

        List<SightingViewModel> svmList = sightingService.getSightingViewModels(0,10);
        model.addAttribute("svmList",svmList);
//                model.addAttribute("superPersonsAtSightings", superPersonsAtSightings);
        return "home/home";
    }
    
    
//        List<Sighting> mostRecentSightings = 
//                sightingService.getAllSightings(0, 10);
//        List<List<SuperPerson>> superPersonsAtSightings = new ArrayList<List<SuperPerson>>();
//        int sightingIndex = 0;
//        
//                for (Sighting currentSighting : mostRecentSightings) {
//                    Integer currentLocationId = currentSighting.getLocation().getLocationId();
//                    currentSighting.setLocation(locationService.getLocationById(currentLocationId));
//                    superPersonsAtSightings.add(superPersonService.getAllSuperPersonsBySighting(currentSighting, 0, 10));
//                }
}

                //get List<SuperPersonSighting> sorted by descending date
                /*

                    Select sps.*
                    from SuperPerson_Sighting sps
                    inner join Sighting s on sps.SightingId = s.SightingId
                    ORDER BY s.Date DESC LIMIT 0,10;

                */
                //for each element in the list, 
                    //get the corresponding SuperPerson
                        //superPersonService.getSuperPersonById(ID from SuperPersonSighting)
                    //also get the corresponding sighting
                        //sightingService.getSightingById(ID from SuperPersonSighting)
                    //and get the corresponding location
                       //locationService.getLocationById(ID from Sighting)
                    //pull the info out of these objects relevant to the model/jsp, convert to strings, and stick into a List<String>
                    //add this list to a larger list
                //add the larger list to the model and send to jsp
                
                //in the jsp, each row in the Latest Sightings table corresponds to one list in the larger list
                //pull out the relevant piece of info for the EL by their order in the list
                    //eg listOfStrings.get(0) is the Sighting Date, listOfStrings.get(1) is the SuperPerson name, etc
                    //here is syntax for getting an element out of a list by index in EL/JSTL
                        //<c:out value="${stringList[0]}/>"
                    
                //i can hear jeff saying that the jsp shouldn't need to know the order of the data
                //i hope there is a better
