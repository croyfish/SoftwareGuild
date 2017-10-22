/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonSighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class SuperPersonSightingDaoDbImpl implements SuperPersonSightingDao {

    private static String SQL_INSERT_SUPERPERSON_SIGHTING = "INSERT into superperson_sighting (SuperPersonId, SightingId) VALUES (?,?);";
    private static String SQL_GET_SUPERPERSON_SIGHTING = "SELECT * from superperson_sighting where SuperPerson_SightingId = ?";
    private static String SQL_UPDATE_SUPERPERSON_SIGHTING = "UPDATE superperson_sighting set SuperPersonId = ?, SightingId = ? WHERE SuperPerson_SightingId = ?";
    private static String SQL_DELETE_SUPERPERSON_SIGHTING = "DELETE FROM superperson_sighting where SuperPerson_SightingId = ?";
    private static String SQL_LIST_SUPERPERSON_SIGHTINGS = "SELECT * from power";       
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }    
    
    @Override
    public SuperPersonSighting createSuperPersonSighting(SuperPersonSighting superPersonSighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonSighting getSuperPersonSightingById(Integer superPersonSightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPersonSighting> getAllSuperPersonSightings(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonSighting updateSuperPersonSighting(SuperPersonSighting superPersonSighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonSighting deleteSuperPersonSighting(SuperPersonSighting superPersonSighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class SuperPersonSightingMapper implements RowMapper<SuperPersonSighting> {

        @Override
        public SuperPersonSighting mapRow(ResultSet rs, int i) throws SQLException {
            SuperPersonSighting sps = new SuperPersonSighting();
            sps.setSuperPersonSightingId(rs.getInt("SuperPerson_SightingId"));
            
            // Lazy load superperson
            SuperPerson superPerson = new SuperPerson();
            superPerson.setSuperPersonId(rs.getInt("SuperPersonId"));
            sps.setSuperPerson(superPerson);
            
            // Lazy load organization
            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("SightingId"));
            sps.setSighting(sighting);
            
            return sps;
        }
    }       
    
}
