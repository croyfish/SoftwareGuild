/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeffc
 */
public class OrganizationDaoDbImpl implements OrganizationDao {

    private static String SQL_INSERT_ORGANIZATION = "INSERT into Organization (Name, Description, Phone, IsGood, LocationId) VALUES (?,?,?,?,?);";
    private static String SQL_GET_ORGANIZATION = "SELECT * from Organization WHERE Organizationid = ?";
    private static String SQL_UPDATE_ORGANIZATION = "UPDATE Organization set Name = ?, Description = ?, Phone = ?, IsGood = ?, LocationId = ? WHERE OrganizationId = ?";
    private static String SQL_DELETE_ORGANIZATION = "DELETE FROM Organization where OrganizationId = ?";
    private static String SQL_LIST_ORGANIZATIONS = "SELECT * from organization LIMIT ?,?";
    
    private static String SQL_LIST_ORGANIZATIONS_BY_SUPERPERSON = "SELECT `Organization`.* FROM `Organization` "
            + "INNER JOIN `SuperPerson_Organization` ON `Organization`.`organizationId` = "
            + "`Superperson_Organization`.`OrganizationId` INNER JOIN `SuperPerson` ON "
            + "`Superperson_Organization`.`superpersonId` = `superPerson`.`superpersonId` "
            + "WHERE `SuperPerson`.`superpersonId` = ? ORDER BY `SuperPerson`.`name` LIMIT ?,?";

    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Organization createOrganization(Organization organization) {
        // Name, Description, Phone, IsGood, LocationId
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                organization.getName(),
                organization.getDescription(),
                organization.getPhone(),
                organization.getIsGood(),
                organization.getLocation().getLocationId());
                
        
        int organizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        organization.setOrganizationId(organizationId);

        return organization;
    }

    @Override
    public Organization getOrganizationById(Integer organizationId) {
        try {
            Organization organization = 
                    jdbcTemplate.queryForObject(SQL_GET_ORGANIZATION, new OrganizationMapper(), organizationId);
            return organization;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations(int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATIONS, new OrganizationMapper(), offset, limit);
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        Location organizationLocation = organization.getLocation();
        
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                organization.getName(),
                organization.getDescription(),
                organization.getPhone(),
                organization.getIsGood(),
                organization.getLocation().getLocationId(),
                organization.getOrganizationId());

        return organization;
    }

    @Override
    public Organization deleteOrganization(Organization organization) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organization.getOrganizationId());
        return organization;
    }

    @Override
    public List<Organization> getAllOrganizationsBySuperPerson(SuperPerson superPerson, int offset, int limit) {
        List<Organization> orgs = jdbcTemplate.query(SQL_LIST_ORGANIZATIONS_BY_SUPERPERSON, new OrganizationMapper(), 
                superPerson.getSuperPersonId(), offset, limit);
        return orgs;
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
            
            //lazy loading FKs -- the service fills in the rest when in use
            Location location = new Location();
            location.setLocationId(rs.getInt("LocationId"));
            org.setLocation(location);
            
            return org;
        }
    }      

}
