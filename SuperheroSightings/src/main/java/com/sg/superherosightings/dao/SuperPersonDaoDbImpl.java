/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
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
public class SuperPersonDaoDbImpl implements SuperPersonDao {

    private static String SQL_INSERT_SUPERPERSON = "INSERT into superperson (Name, Description, IsGood) VALUES (?,?,?);";
    private static String SQL_GET_SUPERPERSON = "SELECT * from superperson where SuperPersonId = ?";
    private static String SQL_UPDATE_SUPERPERSON = "UPDATE superperson set Name = ?, Description = ?, IsGood = ? WHERE SuperPersonId = ?";
    private static String SQL_DELETE_SUPERPERSON = "DELETE FROM superperson where SuperPersonId = ?";
    private static String SQL_LIST_SUPERPERSONS = "SELECT * from superperson LIMIT ?,?";

    private static String SQL_LIST_SUPERPERSONS_BY_SIGHTING = "SELECT `superperson`.* FROM `superperson` "
            + "inner join `superperson_sighting` "
            + "on `superperson`.`SuperPersonId` = `superperson_sighting`.`SuperPersonId` "
            + "inner join `sighting` "
            + "on `superperson_sighting`.`SightingId` = `sighting`.`SightingId` "
            + "where `sighting`.`sightingId` = ? ORDER BY `superperson`.`Name` LIMIT ?,?;";

    private static String SQL_LIST_SUPERPERSONS_BY_SIGHTING_LOCATION = "SELECT `superperson`.* FROM `superperson` "
            + "inner join `superperson_sighting` on `superperson`.`SuperPersonId` = `superperson_sighting`.`SuperPersonId` "
            + "inner join `sighting` on `superperson_sighting`.`SightingId` = `sighting`.`SightingId` "
            + "Inner join `location` on `sighting`.`LocationId` = `location`.`LocationId` "
            + "where `location`.`LocationId` = ? ORDER BY `superperson`.`Name` LIMIT ?,?;";

    private static String SQL_LIST_SUPERPERSONS_BY_ORGANIZATION = "SELECT `superperson`.* FROM `superperson` "
            + "inner join `superperson_organization` "
            + "on `superperson`.`superpersonId` = `superperson_organization`.`superpersonId` "
            + "inner join `organization` "
            + "on `superperson_organization`.`OrganizationId` = `organization`.`OrganizationId` "
            + "where `organization`.`organizationId` = ? ORDER BY `superperson`.`Name` LIMIT ?,?;";

    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

@Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SuperPerson createSuperPerson(SuperPerson superperson) {
            // Name, Description, IsGood
        jdbcTemplate.update(SQL_INSERT_SUPERPERSON,
                superperson.getName(),
                superperson.getDescription(),
                superperson.getIsGood()
                );
        
        int superpersonId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        superperson.setSuperPersonId(superpersonId);

        return superperson;
    }

    @Override
    public SuperPerson getSuperPersonById(Integer superpersonId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_SUPERPERSON,
                    new SuperPersonMapper(),
                    superpersonId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperPerson> getAllSuperPersons(int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSONS,
                new SuperPersonMapper(), offset, limit);
    }

    @Override
    public SuperPerson updateSuperPerson(SuperPerson superperson) {
        jdbcTemplate.update(SQL_UPDATE_SUPERPERSON,
                superperson.getName(),
                superperson.getDescription(),
                superperson.getIsGood(),
                superperson.getSuperPersonId());
        return superperson;
    }

    @Override
    public SuperPerson deleteSuperPerson(SuperPerson superperson) {
        jdbcTemplate.update(SQL_DELETE_SUPERPERSON, superperson.getSuperPersonId());
        return superperson;
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit) {
        String preparedStatement = SQL_LIST_SUPERPERSONS_BY_SIGHTING;
        return jdbcTemplate.query(SQL_LIST_SUPERPERSONS_BY_SIGHTING, new SuperPersonMapper(), sighting.getSightingId(), offset, limit);
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsBySightingLocation(Location location, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsByOrganization(Organization organization, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class SuperPersonMapper implements RowMapper<SuperPerson> {

        @Override
        public SuperPerson mapRow(ResultSet rs, int i) throws SQLException {
            SuperPerson sp = new SuperPerson();
            sp.setSuperPersonId(rs.getInt("SuperPersonId"));
            sp.setName(rs.getString("Name"));
            sp.setDescription(rs.getString("Description"));
            sp.setIsGood(rs.getBoolean("IsGood"));            
            return sp;
        }
    }    

}
