/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperPersonPower;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface SuperPersonPowerDao {
    
    public SuperPersonPower createSuperPersonPower(SuperPersonPower superPersonPower);
    
    public SuperPersonPower getSuperPersonPowerById(Integer superPersonPowerId);
    
    public List<SuperPersonPower> getAllSuperPersonPowers();
    
    public SuperPersonPower updateSuperPersonPower(SuperPersonPower superPersonPower);
    
    public SuperPersonPower deleteSuperPersonPower(Integer superPersonPowerId);
    
}
