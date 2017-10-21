/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Power;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class PowerDaoDbImpl implements PowerDao {

    private static String SQL_INSERT_POWER = "INSERT into power (Name) VALUES (?);";
    private static String SQL_GET_POWER = "SELECT * from power where PowerId = ?";
    private static String SQL_UPDATE_POWER = "UPDATE power set Name = ? WHERE PowerId = ?";
    private static String SQL_DELETE_POWER = "DELETE FROM power where PowerId = ?";
    private static String SQL_LIST_POWERS = "SELECT * from power";      
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
    
    private static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power power = new Power();
            power.setPowerId(rs.getInt("PowerId"));
            power.setName(rs.getString("Name"));
            return power;
        }
    }      
    
}
