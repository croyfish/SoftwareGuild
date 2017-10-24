/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class SightingServiceImpl implements SightingService {

    private SightingDao sightingDao;
    private SuperPersonService superPersonService;

    public SightingServiceImpl(SightingDao sightingDao, SuperPersonService superPersonService) {
        this.sightingDao = sightingDao;
        this.superPersonService = superPersonService;
    }
    
    
    @Override
    public Sighting createSighting(Sighting sighting) {
        return sightingDao.createSighting(sighting);
    }

    @Override
    public Sighting getSightingById(Integer sightingId) {
        return sightingDao.getSightingById(sightingId);
    }

    @Override
    public List<Sighting> getAllSightings(int offset, int limit) {
        return sightingDao.getAllSightings(offset, limit);
    }

    @Override
    public Sighting updateSighting(Sighting sighting) {
        return sightingDao.updateSighting(sighting);
    }

    @Override
    public Sighting deleteSighting(Sighting sighting) {
        return sightingDao.deleteSighting(sighting);
    }

    @Override
    public List<Sighting> getAllSightingsByDate(LocalDate date, int offset, int limit) {
        return sightingDao.getAllSightingsByDate(date, offset, limit);
    }
    
}
