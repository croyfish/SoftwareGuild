/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
import com.sg.superherosightings.model.SuperPersonPower;
import com.sg.superherosightings.model.SuperPersonSighting;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SuperPersonService {
    public SuperPerson createSuperPerson(SuperPerson superPerson);
    public SuperPerson getSuperPersonById(Integer superPersonId);
    public List<SuperPerson> getAllSuperPersons(int offset, int limit);
    public SuperPerson updateSuperPerson(SuperPerson superPerson);
    public SuperPerson deleteSuperPerson(Integer superPersonId);
    //demo
    public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit);
    public List<SuperPerson> getAllSuperPersonsBySightingLocation(Location location, int offset, int limit);
    public List<SuperPerson> getAllSuperPersonsByOrganization(Organization organization, int offset, int limit);
    //bridge management
    public SuperPersonPower addSuperPersonToPower(SuperPerson superPerson, Power power);
    public SuperPersonPower addSuperPersonToPower(Integer superPersonId, Integer powerId);
    public SuperPersonPower deleteSuperPersonFromPower(SuperPerson superPerson, Power power);
    public SuperPersonPower deleteSuperPersonFromPower(Integer superPersonId, Integer powerId);
    
    public SuperPersonOrganization addSuperPersonToOrganization(SuperPerson superPerson, Organization organization);
    public SuperPersonOrganization addSuperPersonToOrganization(Integer superPersonId, Integer organizationId);
    public SuperPersonOrganization deleteSuperPersonFromOrganization(SuperPerson superPerson, Organization organization);
    public SuperPersonOrganization deleteSuperPersonFromOrganization(Integer superPersonId, Integer organizationId);
    
    public SuperPersonSighting addSuperPersonToSighting(SuperPerson superPerson, Sighting sighting);
    public SuperPersonSighting addSuperPersonToSighting(Integer superPersonId, Integer sightingId);
    public SuperPersonSighting deleteSuperPersonFromSighting(SuperPerson superPerson, Sighting sighting);
    public SuperPersonSighting deleteSuperPersonFromSighting(Integer superPersonId, Integer sightingId);
    
    //demo
    
    
}
