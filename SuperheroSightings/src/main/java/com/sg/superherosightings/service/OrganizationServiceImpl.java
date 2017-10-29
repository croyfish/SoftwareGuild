/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.viewmodel.OrganizationViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jeffc
 */
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;
    private SuperPersonService superPersonService;
    
    @Inject
    private LocationService locationService;
    @Inject
    private AddressService addressService;

    public OrganizationServiceImpl(OrganizationDao organizationDao, SuperPersonService superPersonService) {
        this.organizationDao = organizationDao;
        this.superPersonService = superPersonService;
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationDao.createOrganization(organization);
    }

    @Override
    public Organization getOrganizationById(Integer organizationId) {
        return organizationDao.getOrganizationById(organizationId);
    }

    @Override
    public List<Organization> getAllOrganizations(int offset, int limit) {
        return organizationDao.getAllOrganizations(offset, limit);
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return organizationDao.updateOrganization(organization);
    }

    @Override
    public Organization deleteOrganization(Organization organization) {
        return organizationDao.deleteOrganization(organization);
    }

    @Override
    public List<Organization> getAllOrganizationsBySuperPerson(SuperPerson superperson, int offset, int limit) {
        return organizationDao.getAllOrganizationsBySuperPerson(superperson, offset, limit);
    }

    @Override
    public OrganizationViewModel getOrganizationViewModelByOrganizationId(Integer organizationId) {
        
        OrganizationViewModel ovm = new OrganizationViewModel();
        
        Organization organization = getOrganizationById(organizationId);
        ovm.setOrganization(organization);
        
        Integer locationId = organization.getLocation().getLocationId();
        Location location = locationService.getLocationById(locationId);
        ovm.setLocation(location);
        
        Integer addressId = location.getAddress().getAddressId();
        Address address = addressService.getAddressById(addressId);
        ovm.setAddress(address);
        
        List<SuperPerson> superPersonsInOrganization = superPersonService.getAllSuperPersonsByOrganization(
                ovm.getOrganization(), 0, 10);
        
        ovm.setSuperPersons(superPersonsInOrganization);
 
        return ovm;
    }

    @Override
    public List<OrganizationViewModel> getOrganizationViewModels(int offset, int limit) {
        List<OrganizationViewModel> ovmList = new ArrayList();
        List<Organization> viewOrganizations = getAllOrganizations(offset, limit);

        for (int i = 0; i < viewOrganizations.size(); i++) {
            // Make new Model object for each iteration
            OrganizationViewModel currentModel = new OrganizationViewModel();
            // Get the current organization and set it on the model
            Organization currentOrganization = viewOrganizations.get(i);
            currentModel.setOrganization(currentOrganization);
            ovmList.add(currentModel);
        }
        // return the list of models
        return ovmList;
    }

}
