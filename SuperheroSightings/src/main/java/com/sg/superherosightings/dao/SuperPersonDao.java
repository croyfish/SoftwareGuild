/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SuperPersonDao {
    
    //basic CRUD methods
    
    public SuperPerson createSuperPerson(SuperPerson superPerson);
    public SuperPerson getSuperPersonById(Integer superPersonId);
    public List<SuperPerson> getAllSuperPersons(int offset, int limit);
    public SuperPerson updateSuperPerson(SuperPerson superPerson);
    public SuperPerson deleteSuperPerson(SuperPerson superPerson);
    //demo
    public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit);
    public List<SuperPerson> getAllSuperPersonsBySightingLocation(Location location, int offset, int limit);
    public List<SuperPerson> getAllSuperPersonsByOrganization(Organization organization, int offset, int limit);
    public List<SuperPerson> getAllSuperPersonsByPower(Power power, int offset, int limit);
}
