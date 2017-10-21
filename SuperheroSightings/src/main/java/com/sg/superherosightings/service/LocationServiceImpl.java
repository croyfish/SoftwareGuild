/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.SuperPerson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jeffc
 */
public class LocationServiceImpl implements LocationService {

    LocationDao locationDao;
    
    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
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

    @Override
    public List<Location> getAllLocationsBySuperPersonId(Integer superPersonId, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
