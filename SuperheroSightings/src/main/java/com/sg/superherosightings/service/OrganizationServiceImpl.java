/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class OrganizationServiceImpl implements OrganizationService {
    
    private OrganizationDao organizationDao;
    private SuperPersonService superPersonService;

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
    
}
