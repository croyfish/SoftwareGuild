/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperPersonOrganization;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jeffc
 */
public class SuperPersonOrganizationDbImpl implements SuperPersonOrganizationDao {

    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }    
    
    @Override
    public SuperPersonOrganization createSuperPersonOrganization(SuperPersonOrganization superPersonOrganization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonOrganization getSuperPersonOrganizationById(Integer superPersonOrganizationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPersonOrganization> getAllSuperPersonOrganizations(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonOrganization updateSuperPersonOrganization(SuperPersonOrganization superPersonOrganization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonOrganization deleteSuperPersonOrganization(SuperPersonOrganization superPersonOrganization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
