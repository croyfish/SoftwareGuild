/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonOrganization;
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
public class SuperPersonOrganizationDaoDbImpl implements SuperPersonOrganizationDao {

    private static String SQL_INSERT_SUPERPERSON_ORGANIZATION = "INSERT into superperson_organization (SuperPersonId, OrganizationId) VALUES (?,?);";
    private static String SQL_GET_SUPERPERSON_ORGANIZATION = "SELECT * from superperson_organization where SuperPerson_OrganizationId = ?";
    private static String SQL_UPDATE_SUPERPERSON_ORGANIZATION = "UPDATE superperson_organization set SuperPersonId = ?, OrganizationId WHERE SuperPerson_OrganizationId = ?";
    private static String SQL_DELETE_SUPERPERSON_ORGANIZATION = "DELETE FROM superperson_organization where SuperPerson_OrganizationId = ?";
    private static String SQL_LIST_SUPERPERSON_ORGANIZATIONS = "SELECT * from superperson_organization LIMIT ?,?";
    private static String SQL_GET_SUPERPERSONORGANIZATION_BY_SUPERPERSON_AND_ORGANIZATION = "SELECT * FROM SuperPerson_Organization WHERE SuperPersonId = ? AND OrganizationId = ?";

    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SuperPersonOrganization createSuperPersonOrganization(SuperPersonOrganization superPersonOrganization) {

        jdbcTemplate.update(SQL_INSERT_SUPERPERSON_ORGANIZATION,
                superPersonOrganization.getSuperPerson().getSuperPersonId(),
                superPersonOrganization.getOrganization().getOrganizationId());

        int superPersonOrganizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        superPersonOrganization.setSuperPersonOrganizationId(superPersonOrganizationId);

        return superPersonOrganization;
    }

    @Override
    public SuperPersonOrganization getSuperPersonOrganizationById(Integer superPersonOrganizationId) {
        try {
            SuperPersonOrganization superPersonOrganization
                    = jdbcTemplate.queryForObject(SQL_GET_SUPERPERSON_ORGANIZATION, new SuperPersonOrganizationMapper(), superPersonOrganizationId);
            return superPersonOrganization;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<SuperPersonOrganization> getAllSuperPersonOrganizations(int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_ORGANIZATIONS, new SuperPersonOrganizationMapper(), offset, limit);
    }

//    @Override
//    public SuperPersonOrganization updateSuperPersonOrganization(SuperPersonOrganization superPersonOrganization) {
//        Location superPersonOrganizationLocation = superPersonOrganization.getLocation();
//        
//        jdbcTemplate.update(SQL_UPDATE_SUPERPERSON_ORGANIZATION,
//                java.sql.Date.valueOf(superPersonOrganization.getDate()),
//                superPersonOrganizationLocation.getLocationId(),
//                superPersonOrganization.getDescription(), 
//                superPersonOrganization.getSuperPersonOrganizationId()
//                );
//
//        return superPersonOrganization;
//    }
    @Override
    public SuperPersonOrganization deleteSuperPersonOrganization(SuperPersonOrganization superPersonOrganization) {
        jdbcTemplate.update(SQL_DELETE_SUPERPERSON_ORGANIZATION, superPersonOrganization.getSuperPersonOrganizationId());
        return superPersonOrganization;
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

    @Override
    public SuperPersonOrganization getSuperPersonOrganizationBySuperPersonAndOrganization(SuperPerson superPerson, Organization organization) {
        Integer superPersonId = superPerson.getSuperPersonId();
        Integer organizationId = organization.getOrganizationId();
        return jdbcTemplate.queryForObject(SQL_GET_SUPERPERSONORGANIZATION_BY_SUPERPERSON_AND_ORGANIZATION, new SuperPersonOrganizationMapper(), superPersonId, organizationId);

    }

}
