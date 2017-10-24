/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SightingService {
    
    //basic CRUD
    public Sighting createSighting(Sighting sighting);
    public Sighting getSightingById(Integer sightingId);
    public List<Sighting> getAllSightings(int offset, int limit);
    public Sighting updateSighting(Sighting sighting);
    public Sighting deleteSighting(Sighting sighting);
    //demo
    public List<Sighting> getAllSightingsByDate(LocalDate date, int offset, int limit);
    
}
