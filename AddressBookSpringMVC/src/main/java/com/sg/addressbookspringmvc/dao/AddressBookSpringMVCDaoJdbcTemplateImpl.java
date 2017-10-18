/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookspringmvc.dao;

import com.sg.addressbookspringmvc.model.Address;
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
public class AddressBookSpringMVCDaoJdbcTemplateImpl implements AddressBookSpringMVCDao {

    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
 
    private static final String SQL_INSERT_ADDRESS
        = "insert into address (firstName, lastName, streetAddress, city, "
        + "state, zipCode) values (?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_ADDRESS
        = "delete from address where addressId = ?";

    private static final String SQL_UPDATE_ADDRESS
        = "update address set firstName = ?, lastName = ?, streetAddress = ?, "
        + "city = ?, state = ?, zipCode = ?, where addressId =  ?";

    private static final String SQL_SELECT_ADDRESS
        = "select * from address where addressId = ?";

    private static final String SQL_SELECT_ALL_ADDRESSES
        = "select * from address";    

    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode());
        
        int addressId = jdbcTemplate.queryForObject("select Last_ID()", Integer.class);
    
        address.setAddressId(addressId);
    }

    @Override
    public void deleteAddress(int addressId) {
       jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getAddressId());
    }

    @Override
    public Address getAddressById(int addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS,
                    new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ADDRESSES,
                new AddressMapper());
    }
    
    private static final class AddressMapper implements RowMapper<Address> {
        
        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {
            Address add = new Address();
            add.setFirstName(rs.getString("firstName"));
            add.setLastName(rs.getString("lastName"));
            add.setStreetAddress(rs.getString("streetAddress"));
            add.setCity(rs.getString("city"));
            add.setState(rs.getString("state"));
            add.setZipCode(Integer.parseInt(rs.getString("zipCode")));           
            return add;   
        }
    }
    
}
