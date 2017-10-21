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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class SuperPersonDaoDbImpl implements SuperPersonDao {

    private static String SQL_INSERT_SUPERPERSON = "INSERT into superperson (Name, Description, IsGood) VALUES (?,?,?);";
    private static String SQL_GET_SUPERPERSON = "SELECT * from superperson where SuperPersonId = ?";
    private static String SQL_UPDATE_SUPERPERSON = "UPDATE superperson set Name = ?, Description = ?, IsGood = ? WHERE SuperPersonId = ?";
    private static String SQL_DELETE_SUPERPERSON = "DELETE FROM superperson where SuperPersonId = ?";
    private static String SQL_LIST_SUPERPERSONS = "SELECT * from superperson";

    private static String SQL_LIST_SUPERPERSONS_BY_SIGHTING = "SELECT `superperson`.* FROM `superperson` "
            + "inner join `superperson_sighting` "
            + "on `superperson`.`SuperPersonId` = `superperson_sighting`.`SuperPersonId` "
            + "inner join `sighting` "
            + "on `superperson_sighting`.`SightingId` = `sighting`.`SightingId` "
            + "where `sighting`.`sightingId` = ? ORDER BY `superperson`.`Name`;";

    private static String SQL_LIST_SUPERPERSONS_BY_SIGHTING_LOCATION = "SELECT `superperson`.* FROM `superperson` "
            + "inner join `superperson_sighting` on `superperson`.`SuperPersonId` = `superperson_sighting`.`SuperPersonId` "
            + "inner join `sighting` on `superperson_sighting`.`SightingId` = `sighting`.`SightingId` "
            + "Inner join `location` on `sighting`.`LocationId` = `location`.`LocationId` "
            + "where `location`.`LocationId` = ? ORDER BY `superperson`.`Name`;";

    private static String SQL_LIST_SUPERPERSONS_BY_ORGANIZATION = "SELECT `superperson`.* FROM `superperson` "
            + "inner join `superperson_organization` "
            + "on `superperson`.`superpersonId` = `superperson_organization`.`superpersonId` "
            + "inner join `organization` "
            + "on `superperson_organization`.`OrganizationId` = `organization`.`OrganizationId` "
            + "where `organization`.`organizationId` = ? ORDER BY `superperson`.`Name`;";

    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SuperPerson createSuperPerson(SuperPerson superPerson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPerson getSuperPersonById(Integer superPersonId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPerson> getAllSuperPersons(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPerson updateSuperPerson(SuperPerson superPerson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPerson deleteSuperPerson(Integer superPersonId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPerson> getAllSuperPersonsBySighting(Sighting sighting, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            sp.setDescription(rs.getString("Description"));
            sp.setIsGood(rs.getBoolean("IsGood"));            
            return sp;
        }
    }    

}
