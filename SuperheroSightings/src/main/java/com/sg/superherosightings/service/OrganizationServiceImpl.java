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
import static jdk.nashorn.internal.objects.NativeUint16Array.constructor;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization getOrganizationById(Integer organizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organization> getAllOrganizations(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization deleteOrganization(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organization> getAllOrganizationsBySuperPerson(SuperPerson superperson, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
