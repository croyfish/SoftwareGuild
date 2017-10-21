/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class SuperPersonOrganizationDaoDbImpl implements SuperPersonOrganizationDao {

    private static String SQL_INSERT_SUPERPERSON_ORGANIZATION = "INSERT into superperson_organization (SuperPersonId, OrganizationId) VALUES (?,?);";
    private static String SQL_GET_SUPERPERSON_ORGANIZATION = "SELECT * from superperson_organization where SuperPerson_OrganizationId = ?";
    private static String SQL_UPDATE_SUPERPERSON_ORGANIZATION = "UPDATE superperson_organization set SuperPersonId = ?, OrganizationId WHERE SuperPerson_OrganizationId = ?";
    private static String SQL_DELETE_SUPERPERSON_ORGANIZATION = "DELETE FROM superperson_organization where SuperPerson_OrganizationId = ?";
    private static String SQL_LIST_SUPERPERSON_ORGANIZATIONS = "SELECT * from superperson_organization";       
    
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
    
    private static final class SuperPersonOrganizationMapper implements RowMapper<SuperPersonOrganization> {

        @Override
        public SuperPersonOrganization mapRow(ResultSet rs, int i) throws SQLException {
            SuperPersonOrganization spo = new SuperPersonOrganization();
            spo.setSuperPersonOrganizationId(rs.getInt("SuperPerson_OrganizationId"));
            
            // Lazy load superperson
            SuperPerson superPerson = new SuperPerson();
            superPerson.setSuperPersonId(rs.getInt("SuperPersonId"));
            spo.setSuperPerson(superPerson);
            
            // Lazy load organization
            Organization organization = new Organization();
            organization.setOrganizationId(rs.getInt("OrganizationId"));
            spo.setOrganization(organization);
            
            return spo;
        }
    }    
    
}
