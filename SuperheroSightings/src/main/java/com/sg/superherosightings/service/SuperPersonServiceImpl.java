/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.commandmodel.CreateSuperPersonCommandModel;
import com.sg.superherosightings.dao.LocationDao;
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
import com.sg.superherosightings.viewmodel.SuperPersonViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

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

    @Inject
    private LocationDao locationDao;

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
    public SuperPerson buildSuperPersonFromCommandModel(CreateSuperPersonCommandModel cspcm) {

        SuperPerson newSuperPerson = new SuperPerson();
        newSuperPerson.setName(cspcm.getName());
        newSuperPerson.setDescription(cspcm.getDescription());
        String reputation = cspcm.getReputation();

        if (reputation != null) {
            if (reputation.equals("good")) {
                newSuperPerson.setIsGood(true);
            } else if (reputation.equals("evil")) {
                newSuperPerson.setIsGood(false);
            }
        }

        newSuperPerson = superPersonDao.createSuperPerson(newSuperPerson);

        return newSuperPerson;

    }

    @Override
    public List<SuperPersonPower> addSuperPersonToPowers(Integer superPersonId, Integer[] powerIds) {
        List<SuperPersonPower> spps = new ArrayList<SuperPersonPower>();

        for (Integer currentPowerId : powerIds) {
            SuperPersonPower spp = this.addSuperPersonToPower(superPersonId,
                    currentPowerId);
            spps.add(spp);
        }
        return spps;
    }

    @Override
    public List<SuperPersonOrganization> addSuperPersonToOrganizations(Integer superPersonId, Integer[] organizationIds) {
        List<SuperPersonOrganization> spos = new ArrayList<SuperPersonOrganization>();

        for (Integer currentOrgId : organizationIds) {
            SuperPersonOrganization spo = this.addSuperPersonToOrganization(superPersonId, currentOrgId);
            spos.add(spo);
        }
        return spos;
    }

    @Override
    public SuperPerson getSuperPersonById(Integer superPersonId) {
        return superPersonDao.getSuperPersonById(superPersonId);
    }

    @Override
    public List<SuperPerson> getAllSuperPersons(int offset, int limit) {
        return superPersonDao.getAllSuperPersons(offset, limit);
    }

    @Override
    public SuperPerson updateSuperPerson(SuperPerson superPerson) {
        return superPersonDao.updateSuperPerson(superPerson);
    }

    @Override
    public SuperPerson deleteSuperPerson(SuperPerson superPerson) {

        List<Sighting> sightingsForSuperPerson = sightingDao.getAllSightingsBySuperPerson(superPerson, 0, Integer.MAX_VALUE);
        for (Sighting currentSighting : sightingsForSuperPerson) {
            deleteSightingFromSuperPerson(superPerson, currentSighting);
        }

        List<Organization> organizationsForSuperPerson = organizationDao.getAllOrganizationsBySuperPerson(superPerson, 0, Integer.MAX_VALUE);
        for (Organization currentOrganization : organizationsForSuperPerson) {
            deleteOrganizationFromSuperPerson(superPerson, currentOrganization);
        }

        List<Power> powersForSuperPerson = powerDao.getAllPowersBySuperPerson(superPerson, 0, Integer.MAX_VALUE);
        for (Power currentPower : powersForSuperPerson) {
            deletePowerFromSuperPerson(superPerson, currentPower);
        }

        return superPersonDao.deleteSuperPerson(superPerson);
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit) {
        return superPersonDao.getAllSuperPersonsBySighting(sighting, offset, limit);
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsBySightingLocation(Location location, int offset, int limit) {
        return superPersonDao.getAllSuperPersonsBySightingLocation(location, offset, limit);
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsByOrganization(Organization organization, int offset, int limit) {
        return superPersonDao.getAllSuperPersonsByOrganization(organization, offset, limit);
    }

    // Added get
    @Override
    public SuperPersonPower addSuperPersonToPower(SuperPerson superPerson, Power power) {
        SuperPersonPower spp = new SuperPersonPower();
        spp.setSuperPerson(superPerson);
        spp.setPower(power);
        return superPersonPowerDao.createSuperPersonPower(spp);
    }

    @Override
    public SuperPersonPower addSuperPersonToPower(Integer superPersonId, Integer powerId) {
        return addSuperPersonToPower(superPersonDao.getSuperPersonById(superPersonId),
                powerDao.getPowerById(powerId));
    }

    @Override
    public SuperPersonPower deletePowerFromSuperPerson(SuperPerson superPerson, Power power) {
        SuperPersonPower superPersonPower = superPersonPowerDao.getSuperPersonPowerBySuperPersonAndPower(superPerson, power);
        return superPersonPowerDao.deleteSuperPersonPower(superPersonPower);
    }

    @Override
    public SuperPersonPower deletePowerFromSuperPerson(Integer superPersonId, Integer powerId) {
        SuperPerson superPerson = superPersonDao.getSuperPersonById(superPersonId);
        Power power = powerDao.getPowerById(powerId);
        SuperPersonPower superPersonPower = superPersonPowerDao.getSuperPersonPowerBySuperPersonAndPower(superPerson, power);
        return superPersonPowerDao.deleteSuperPersonPower(superPersonPower);
    }

    @Override
    public SuperPersonOrganization addSuperPersonToOrganization(SuperPerson superPerson, Organization organization) {
        SuperPersonOrganization spo = new SuperPersonOrganization();
        spo.setSuperPerson(superPerson);
        spo.setOrganization(organization);
        return superPersonOrganizationDao.createSuperPersonOrganization(spo);
    }

    @Override
    public SuperPersonOrganization addSuperPersonToOrganization(Integer superPersonId, Integer organizationId) {
        return addSuperPersonToOrganization(superPersonDao.getSuperPersonById(superPersonId),
                organizationDao.getOrganizationById(organizationId));
    }

    @Override
    public SuperPersonOrganization deleteOrganizationFromSuperPerson(SuperPerson superPerson, Organization organization) {
        SuperPersonOrganization superPersonOrganization
                = superPersonOrganizationDao.getSuperPersonOrganizationBySuperPersonAndOrganization(superPerson, organization);
        return superPersonOrganizationDao.deleteSuperPersonOrganization(superPersonOrganization);
    }

    @Override
    public SuperPersonOrganization deleteOrganizationFromSuperPerson(Integer superPersonId, Integer organizationId) {
        SuperPerson superPerson = superPersonDao.getSuperPersonById(superPersonId);
        Organization organization = organizationDao.getOrganizationById(organizationId);
        SuperPersonOrganization superPersonOrganization
                = superPersonOrganizationDao.getSuperPersonOrganizationBySuperPersonAndOrganization(superPerson, organization);
        return superPersonOrganizationDao.deleteSuperPersonOrganization(superPersonOrganization);
    }

    @Override
    public SuperPersonSighting addSuperPersonToSighting(SuperPerson superPerson, Sighting sighting) {
        SuperPersonSighting sps = new SuperPersonSighting();
        sps.setSuperPerson(superPerson);
        sps.setSighting(sighting);
        return superPersonSightingDao.createSuperPersonSighting(sps);
    }

    @Override
    public SuperPersonSighting addSuperPersonToSighting(Integer superPersonId, Integer sightingId) {
        return addSuperPersonToSighting(superPersonDao.getSuperPersonById(superPersonId),
                sightingDao.getSightingById(sightingId));
    }

    @Override
    public SuperPersonSighting deleteSightingFromSuperPerson(SuperPerson superPerson, Sighting sighting) {
        SuperPersonSighting superPersonSighting
                = superPersonSightingDao.getSuperPersonSightingBySuperPersonAndSighting(superPerson, sighting);
        return superPersonSightingDao.deleteSuperPersonSighting(superPersonSighting);
    }

    @Override
    public List<SuperPersonViewModel> getSuperPersonViewModels(int offset, int limit) {
        List<SuperPersonViewModel> spvmList = new ArrayList();
        List<SuperPerson> viewSuperPersons = getAllSuperPersons(offset, limit);

        for (int i = 0; i < viewSuperPersons.size(); i++) {
            SuperPersonViewModel currentModel = new SuperPersonViewModel();
            SuperPerson currentSuperPerson = viewSuperPersons.get(i);
            currentModel.setSuperPerson(currentSuperPerson);
            spvmList.add(currentModel);
        }

        return spvmList;
    }

    @Override
    public SuperPersonViewModel getSuperPersonViewModelBySuperPersonId(Integer superPersonId) {
        SuperPersonViewModel spvm = new SuperPersonViewModel();
        SuperPerson superPerson = getSuperPersonById(superPersonId);
        List<Sighting> sightingsForSuperPersonNoLocation = sightingDao.getAllSightingsBySuperPerson(superPerson, 0, 10);
        List<Organization> orgsForSuperPerson = organizationDao.getAllOrganizationsBySuperPerson(superPerson, 0, 10);
        List<Sighting> sightingsForSuperPersonWithLocation = new ArrayList<Sighting>();
        List<Power> powersForSuperPerson = powerDao.getAllPowersBySuperPerson(superPerson, 0, 10);

        for (Sighting currentSighting : sightingsForSuperPersonNoLocation) {
            Location currentLocation = locationDao.getLocationById(currentSighting.getLocation().getLocationId());
            currentSighting.setLocation(currentLocation);
            sightingsForSuperPersonWithLocation.add(currentSighting);
        }

        spvm.setSuperPerson(superPerson);
        spvm.setSightings(sightingsForSuperPersonWithLocation);
        spvm.setOrganizations(orgsForSuperPerson);
        spvm.setPowers(powersForSuperPerson);

        return spvm;
    }

    @Override
    public SuperPersonSighting deleteSightingFromSuperPerson(Integer superPersonId, Integer sightingId) {
        SuperPerson superPerson = superPersonDao.getSuperPersonById(superPersonId);
        Sighting sighting = sightingDao.getSightingById(sightingId);
        SuperPersonSighting superPersonSighting
                = superPersonSightingDao.getSuperPersonSightingBySuperPersonAndSighting(superPerson, sighting);
        return superPersonSightingDao.deleteSuperPersonSighting(superPersonSighting);
    }

    @Override
    public SuperPerson createSuperPerson(SuperPerson superPerson) {
        return superPersonDao.createSuperPerson(superPerson);
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsByPower(Power power, int offset, int limit) {
        return superPersonDao.getAllSuperPersonsByPower(power, offset, limit);
    }
}
