/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperPersonOrganization;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SuperPersonOrganizationDao {
    
    public SuperPersonOrganization createSuperPersonOrganization(SuperPersonOrganization superPersonOrganization);
    
    public SuperPersonOrganization getSuperPersonOrganizationById(Integer superPersonOrganizationId);
    
    public List<SuperPersonOrganization> getAllSuperPersonOrganizations(int offset, int limit);
    
    public SuperPersonOrganization updateSuperPersonOrganization(SuperPersonOrganization superPersonOrganization);
    
    public SuperPersonOrganization deleteSuperPersonOrganization(SuperPersonOrganization superPersonOrganization);    
    
}
