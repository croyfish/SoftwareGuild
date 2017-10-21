/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.PowerDao;
import com.sg.superherosightings.model.Power;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeUint16Array.constructor;

/**
 *
 * @author jeffc
 */
public class PowerServiceImpl implements PowerService {
    
    private PowerDao powerDao;
    private SuperPersonService superPersonService;

    public PowerServiceImpl(PowerDao powerDao, SuperPersonService superPersonService) {
        this.powerDao = powerDao;
        this.superPersonService = superPersonService;
    }

    

    @Override
    public Power createPower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power getPowerById(Integer powerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Power> getAllPowers(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power updatePower(Power power) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power deletePower(Integer powerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
