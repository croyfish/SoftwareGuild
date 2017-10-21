/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.SuperPerson;
import com.sg.superherosightings.model.SuperPersonPower;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class SuperPersonPowerDaoDbImpl implements SuperPersonPowerDao {

    private static String SQL_INSERT_SUPERPERSON_POWER = "INSERT into superperson_power (SuperPersonId, PowerId) VALUES (?,?);";
    private static String SQL_GET_SUPERPERSON_POWER = "SELECT * from superperson_power where SuperPerson_PowerId = ?";
    private static String SQL_UPDATE_SUPERPERSON_POWER = "UPDATE superperson_power set SuperPersonId = ?, PowerId = ? WHERE SuperPerson_PowerId = ?";
    private static String SQL_DELETE_SUPERPERSON_POWER = "DELETE FROM superperson_power where SuperPerson_PowerId = ?";
    private static String SQL_LIST_SUPERPERSON_POWERS = "SELECT * from superperson_power";       
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }    
    
    @Override
    public SuperPersonPower createSuperPersonPower(SuperPersonPower superPersonPower) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonPower getSuperPersonPowerById(Integer superPersonPowerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuperPersonPower> getAllSuperPersonPowers(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonPower updateSuperPersonPower(SuperPersonPower superPersonPower) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuperPersonPower deleteSuperPersonPower(Integer superPersonPowerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class SuperPersonPowerMapper implements RowMapper<SuperPersonPower> {

        @Override
        public SuperPersonPower mapRow(ResultSet rs, int i) throws SQLException {
            SuperPersonPower spp = new SuperPersonPower();
            spp.setSuperPersonPowerId(rs.getInt("SuperPerson_PowerId"));
            
            // Lazy load superperson
            SuperPerson superPerson = new SuperPerson();
            superPerson.setSuperPersonId(rs.getInt("SuperPersonId"));
            spp.setSuperPerson(superPerson);
            
            // Lazy load power
            Power power = new Power();
            power.setPowerId(rs.getInt("PowerId"));
            spp.setPower(power);
            
            return spp;
        }
    }       
    
}
