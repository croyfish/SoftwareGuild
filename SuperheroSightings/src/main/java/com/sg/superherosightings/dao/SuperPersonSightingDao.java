/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperPersonSighting;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SuperPersonSightingDao {
    public SuperPersonSighting createSuperPersonSighting(SuperPersonSighting superPersonSighting);
    public SuperPersonSighting getSuperPersonSightingById(Integer superPersonSightingId);
    public List<SuperPersonSighting> getAllSuperPersonSightings();
    public SuperPersonSighting updateSuperPersonSighting(SuperPersonSighting superPersonSighting);
    public SuperPersonSighting deleteSuperPersonSighting(Integer superPersonSightingId);
}
