/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
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
public class LocationDaoDbImpl implements LocationDao {

    private static String SQL_INSERT_LOCATION = "INSERT into location (Name, Description, Latitude, Longitude, AddressId) VALUES (?,?,?,?,?);";
    private static String SQL_GET_LOCATION = "SELECT * from location where LocationId = ?";
    private static String SQL_UPDATE_LOCATION = "UPDATE location set Name = ?, Description = ?, Latitude = ?, Longitude = ?, AddressId = ? WHERE LocationId = ?";
    private static String SQL_DELETE_LOCATION = "DELETE FROM location where LocationId = ?";
    private static String SQL_LIST_LOCATIONS = "SELECT * from location LIMIT ?,?";
    
    private static String SQL_LIST_LOCATIONS_BY_SUPERPERSON = "SELECT `location`.* FROM `location` "
            + "INNER JOIN `location` "
            + "ON `location`.`LocationId` = `location`.`LocationId` "
            + "INNER JOIN `superperson_location` "
            + "ON `superperson_location`.`LocationId` = `location`.`LocationId` "
            + "INNER JOIN `superperson` "
            + "ON `superperson_location`.`SuperpersonId` = `superperson`.`SuperPersonId` "
            + "WHERE `superperson`.`SuperPersonId` = ? ORDER BY `location`.`Name` LIMIT ?,?;";
            
          
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Location createLocation(Location location) {
        // Name, Description, Latitude, Longitude, AddressId
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getLatitude(),
                location.getLongitude(),
                location.getAddress().getAddressId());
                
        
        int locationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        location.setLocationId(locationId);

        return location;
    }

    @Override
    public Location getLocationById(Integer locationId) {
        try {
            Location location = 
                    jdbcTemplate.queryForObject(SQL_GET_LOCATION, new LocationMapper(), locationId);
            return location;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations(int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_LOCATIONS, new LocationMapper(), offset, limit);
    }

    @Override
    public Location updateLocation(Location location) {
        
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getName(),
                location.getDescription(),
                location.getLatitude(),
                location.getLongitude(),
                location.getAddress().getAddressId(),
                location.getLocationId()
                );

        return location;
    }

    @Override
    public Location deleteLocation(Location location) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, location.getLocationId());
        return location;
    }

    @Override
    public List<Location> getAllLocationsBySuperPerson(SuperPerson superPerson, int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_LOCATIONS_BY_SUPERPERSON, new LocationMapper(), superPerson, offset, limit);
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
