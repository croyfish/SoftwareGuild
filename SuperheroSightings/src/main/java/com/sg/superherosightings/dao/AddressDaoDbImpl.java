/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class AddressDaoDbImpl implements AddressDao {
    
    private static String SQL_INSERT_ADDRESS = "INSERT into address (Street, City, State, Zipcode) VALUES (?,?,?,?);";
    private static String SQL_GET_ADDRESS = "SELECT * from address where AddressId = ?";
    private static String SQL_UPDATE_ADDRESS = "UPDATE address set Street = ?, City = ?, State = ?, Zipcode? WHERE AddressId = ?";
    private static String SQL_DELETE_ADDRESS = "DELETE FROM address where AddressId = ?";
    private static String SQL_LIST_ADDRESSES = "SELECT * from address";    
    
    
    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Address createAddress(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address getAddressById(Integer addressId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAllAddresses(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address updateAddress(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address deleteAddress(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class AddressMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {
            Address add = new Address();
            add.setAddressId(rs.getInt("AddressId"));
            add.setStreet(rs.getString("Street"));
            add.setCity(rs.getString("City"));
            add.setState(rs.getString("State"));
            add.setZipcode(rs.getString("Zipcode"));
            return add;
        }
    }    
    
}
