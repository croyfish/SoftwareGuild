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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeffc
 */
public class PowerDaoDbImpl implements PowerDao {

    private static String SQL_INSERT_POWER = "INSERT into power (Name) VALUES (?);";
    private static String SQL_GET_POWER = "SELECT * from power where PowerId = ?";
    private static String SQL_UPDATE_POWER = "UPDATE power set Name = ? WHERE PowerId = ?";
    private static String SQL_DELETE_POWER = "DELETE FROM power where PowerId = ?";
    private static String SQL_LIST_POWERS = "SELECT * from power LIMIT ?,?";      
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
   @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Power createPower(Power power) {

        jdbcTemplate.update(SQL_INSERT_POWER,
                power.getName());
        
        int powerId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        power.setPowerId(powerId);

        return power;
    }

    @Override
    public Power getPowerById(Integer powerId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_POWER,
                    new PowerMapper(),
                    powerId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Power> getAllPowers(int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_POWERS,
                new PowerMapper(), offset, limit);
    }

    @Override
    public Power updatePower(Power power) {
        jdbcTemplate.update(SQL_UPDATE_POWER,
                power.getName(),
                power.getPowerId());
        return power;
    }

    @Override
    public Power deletePower(Power power) {
        jdbcTemplate.update(SQL_DELETE_POWER, power.getPowerId());
        return power;
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
