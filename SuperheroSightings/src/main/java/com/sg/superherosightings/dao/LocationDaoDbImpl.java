/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
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
public class LocationDaoDbImpl implements LocationDao {

    private static String SQL_INSERT_LOCATION = "INSERT into location (Name, Description, Latitude, Longitude, LocationId) VALUES (?,?,?,?,?);";
    private static String SQL_GET_LOCATION = "SELECT * from location where LocationId = ?";
    private static String SQL_UPDATE_LOCATION = "UPDATE location set Name = ?, Description = ?, Latitude = ?, Longitude = ?, AddressId = ? WHERE LocationId = ?";
    private static String SQL_DELETE_LOCATION = "DELETE FROM location where LocationId = ?";
    private static String SQL_LIST_LOCATIONS = "SELECT * from location";
    
    private static String SQL_LIST_LOCATIONS_BY_SUPERPERSON = "SELECT `location`.* FROM `location` "
            + "INNER JOIN `sighting` "
            + "ON `location`.`LocationId` = `sighting`.`LocationId` "
            + "INNER JOIN `superperson_sighting` "
            + "ON `superperson_sighting`.`SightingId` = `sighting`.`SightingId` "
            + "INNER JOIN `superperson` "
            + "ON `superperson_sighting`.`SuperpersonId` = `superperson`.`SuperPersonId` "
            + "WHERE `superperson`.`SuperPersonId` = ? ORDER BY `location`.`Name`;";
            
          
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Location createLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getLocationById(Integer locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getAllLocations(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location updateLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location deleteLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getAllLocationsBySuperPerson(SuperPerson superperson, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location loc = new Location();
            loc.setLocationId(rs.getInt("LocationId"));
            loc.setName(rs.getString("Name"));
            loc.setDescription(rs.getString("Description"));
            
            // Lazy load address
            Address address = new Address();
            address.setAddressId(rs.getInt("AddressId"));
            loc.setAddress(address);
            
            loc.setLatitude(rs.getString("Latitude"));
            loc.setLongitude(rs.getString("Longitude"));
            return loc;
        }    
    }
}
