/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class OrganizationDaoDbImpl implements OrganizationDao {

    private static String SQL_INSERT_ORGANIZATION = "INSERT into organization (Name, Description, Phone, IsGood, OrganizationId) VALUES (?,?,?,?,?);";
    private static String SQL_GET_ORGANIZATION = "SELECT * from organization where Organizationid = ?";
    private static String SQL_UPDATE_ORGANIZATION = "UPDATE organization set Name = ?, Description = ?, Phone = ?, IsGood = ?, LocationId = ? WHERE OrganizationId = ?";
    private static String SQL_DELETE_ORGANIZATION = "DELETE FROM organization where OrganizationId = ?";
    private static String SQL_LIST_ORGANIZATIONS = "SELECT * from organization";
    
    private static String SQL_LIST_ORGANIZATIONS_BY_SUPERPERSON = "SELECT `organization`.* FROM `organization` "
            + "INNER JOIN `superperson_organization` ON `organization`.`organizationId` = "
            + "`superperson_organization`.`organizationId` INNER JOIN `superperson` ON "
            + "`superperson_organization`.`superpersonId` = `superperson`.`superpersonId` "
            + "WHERE `superperson`.`superpersonid` = ? ORDER BY `superperson`.`name`";

    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
    
    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization org = new Organization();
            org.setOrganizationId(rs.getInt("OrganizationId"));
            org.setName(rs.getString("Name"));
            org.setDescription(rs.getString("Description"));
            org.setPhone(rs.getString("Phone"));
            org.setIsGood(rs.getBoolean("IsGood"));
            return org;
        }
    }      

}
