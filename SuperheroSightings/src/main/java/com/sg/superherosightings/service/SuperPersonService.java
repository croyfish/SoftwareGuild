/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.commandmodel.CreateSuperPersonCommandModel;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
import com.sg.superherosightings.model.SuperPersonPower;
import com.sg.superherosightings.model.SuperPersonSighting;
import com.sg.superherosightings.viewmodel.SuperPersonViewModel;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SuperPersonService {
    public SuperPerson createSuperPerson(SuperPerson superPerson);
    public SuperPerson buildSuperPersonFromCommandModel(CreateSuperPersonCommandModel cspcm); //new
    public SuperPerson getSuperPersonById(Integer superPersonId);
    public List<SuperPerson> getAllSuperPersons(int offset, int limit);
    public SuperPerson updateSuperPerson(SuperPerson superPerson);
    public SuperPerson deleteSuperPerson(SuperPerson superPerson);
    //demo
    public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit);
    public List<SuperPerson> getAllSuperPersonsBySightingLocation(Location location, int offset, int limit);
    public List<SuperPerson> getAllSuperPersonsByOrganization(Organization organization, int offset, int limit);
    //bridge management
    public SuperPersonPower addSuperPersonToPower(SuperPerson superPerson, Power power);
    public List<SuperPersonPower> addSuperPersonToPowers(Integer superPersonId, Integer[] powerIds); //new
    public SuperPersonPower addSuperPersonToPower(Integer superPersonId, Integer powerId);
    public SuperPersonPower deletePowerFromSuperPerson(SuperPerson superPerson, Power power);
    public SuperPersonPower deletePowerFromSuperPerson(Integer superPersonId, Integer powerId);
    
    public SuperPersonOrganization addSuperPersonToOrganization(SuperPerson superPerson, Organization organization);
    public List<SuperPersonOrganization> addSuperPersonToOrganizations(Integer superPersonId, Integer[] orgIds); //new
    public SuperPersonOrganization addSuperPersonToOrganization(Integer superPersonId, Integer orgId);
    public SuperPersonOrganization deleteOrganizationFromSuperPerson(SuperPerson superPerson, Organization organization);
    public SuperPersonOrganization deleteOrganizationFromSuperPerson(Integer superPersonId, Integer organizationId);
    
    public SuperPersonSighting addSuperPersonToSighting(SuperPerson superPerson, Sighting sighting);
    public SuperPersonSighting addSuperPersonToSighting(Integer superPersonId, Integer sightingId);
    public SuperPersonSighting deleteSightingFromSuperPerson(SuperPerson superPerson, Sighting sighting);
    public SuperPersonSighting deleteSightingFromSuperPerson(Integer superPersonId, Integer sightingId);
    
    //demo
    
    public List<SuperPerson> getAllSuperPersonsByPower(Power power, int offset, int limit);
    public List<SuperPersonViewModel> getSuperPersonViewModels(int offset, int limit);
    public SuperPersonViewModel getSuperPersonViewModelBySuperPersonId(Integer superPersonId);    

}
