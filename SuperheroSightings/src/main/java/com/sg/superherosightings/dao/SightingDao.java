/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SightingDao {
    //basic CRUD
    public Sighting createSighting(Sighting sighting);
    public Sighting getSightingById(Integer sightingId);
    public List<Sighting> getAllSightings();
    public Sighting updateSighting(Sighting sighting);
    public Sighting deleteSighting(Integer sightingId);
    //demo
    public List<Sighting> getAllSightingsByDate(LocalDate date);
}
