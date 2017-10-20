/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.SuperPerson;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface LocationDao {
    
    public Location createLocation(Location location);
    
    public Location getLocationById(Integer locationId);
    
    public List<Location> getAllLocations();
    
    public Location updateLocation(Location location);
    
    public Location deleteLocation(Location location);
    
    public List<Location> getAllLocationsBySuperPerson(SuperPerson superperson);
    
}
