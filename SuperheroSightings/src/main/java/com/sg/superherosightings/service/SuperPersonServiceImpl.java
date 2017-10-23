/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.PowerDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperPersonDao;
import com.sg.superherosightings.dao.SuperPersonOrganizationDao;
import com.sg.superherosightings.dao.SuperPersonPowerDao;
import com.sg.superherosightings.dao.SuperPersonSightingDao;
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
public class SuperPersonServiceImpl implements SuperPersonService {

    private SuperPersonDao superPersonDao;
    private OrganizationDao organizationDao;
    private PowerDao powerDao;
    private SightingDao sightingDao;
    private SuperPersonOrganizationDao superPersonOrganizationDao;
    private SuperPersonPowerDao superPersonPowerDao;
    private SuperPersonSightingDao superPersonSightingDao;

    public SuperPersonServiceImpl(SuperPersonDao superPersonDao, OrganizationDao organizationDao, PowerDao powerDao, SightingDao sightingDao, SuperPersonOrganizationDao superPersonOrganizationDao, SuperPersonPowerDao superPersonPowerDao, SuperPersonSightingDao superPersonSightingDao) {
        this.superPersonDao = superPersonDao;
        this.organizationDao = organizationDao;
        this.powerDao = powerDao;
        this.sightingDao = sightingDao;
        this.superPersonOrganizationDao = superPersonOrganizationDao;
        this.superPersonPowerDao = superPersonPowerDao;
        this.superPersonSightingDao = superPersonSightingDao;
    }
    
    @Override
    public SuperPerson createSuperPerson(SuperPerson superPerson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPerson getSuperPersonById(Integer superPersonId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPerson> getAllSuperPersons(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPerson updateSuperPerson(SuperPerson superPerson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPerson deleteSuperPerson(Integer superPersonId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit) {
        return superPersonDao.getAllSuperPersonsBySighting(sighting, offset, limit);
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsBySightingLocation(Location location, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsByOrganization(Organization organization, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonPower addSuperPersonToPower(SuperPerson superPerson, Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonPower addSuperPersonToPower(Integer superPersonId, Integer powerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonPower deleteSuperPersonFromPower(SuperPerson superPerson, Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonPower deleteSuperPersonFromPower(Integer superPersonId, Integer powerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonOrganization addSuperPersonToOrganization(SuperPerson superPerson, Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonOrganization addSuperPersonToOrganization(Integer superPersonId, Integer organizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonOrganization deleteSuperPersonFromOrganization(SuperPerson superPerson, Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonOrganization deleteSuperPersonFromOrganization(Integer superPersonId, Integer organizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonSighting addSuperPersonToSighting(SuperPerson superPerson, Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonSighting addSuperPersonToSighting(Integer superPersonId, Integer sightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonSighting deleteSuperPersonFromSighting(SuperPerson superPerson, Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonSighting deleteSuperPersonFromSighting(Integer superPersonId, Integer sightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
