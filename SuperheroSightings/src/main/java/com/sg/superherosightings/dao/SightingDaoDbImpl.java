/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jeffc
 */
public class SightingDaoDbImpl implements SightingDao {

    private static String SQL_INSERT_SIGHTING = "INSERT into sighting (Date, LocationId, Description) VALUES (?,?,?);";
    private static String SQL_GET_SIGHTING = "SELECT * from sighting where SightingId = ?";
    private static String SQL_UPDATE_SIGHTING = "UPDATE sighting set Date = ?, LocationId = ?, Description = ? WHERE SightingId = ?";
    private static String SQL_DELETE_SIGHTING = "DELETE FROM sighting where SightingId = ?";
    private static String SQL_LIST_SIGHTINGS = "SELECT * from sighting";
    private static String SQL_LIST_SIGHTING_BY_DATE = "SELECT `sighting`.* FROM `sighting` "
            + "WHERE `date`= ? ORDER BY `sighting`.`SightingId`;";
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Sighting createSighting(Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sighting getSightingById(Integer sightingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sighting> getAllSightings(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sighting updateSighting(Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sighting deleteSighting(Sighting sighting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sighting> getAllSightingsByDate(LocalDate date, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sig = new Sighting();
            sig.setSightingId(rs.getInt("SightingId"));
            sig.setDate(rs.getDate("Date").toLocalDate());
            
            // Lazy load location
            Location location = new Location();
            location.setLocationId(rs.getInt("LocationId"));
            sig.setLocation(location);
            
            sig.setDescription(rs.getString("Description"));
            return sig;
        }
    }
    
    
}
