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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeffc
 */
public class AddressDaoDbImpl implements AddressDao {

    private static String SQL_INSERT_ADDRESS = "INSERT into address (Street, City, State, Zipcode) VALUES (?,?,?,?);";
    private static String SQL_GET_ADDRESS = "SELECT * from address WHERE AddressId = ?";
    private static String SQL_UPDATE_ADDRESS = "UPDATE address set Street = ?, City = ?, State = ?, Zipcode = ? WHERE AddressId = ?";
    private static String SQL_DELETE_ADDRESS = "DELETE FROM address WHERE AddressId = ?";
    private static String SQL_LIST_ADDRESSES = "SELECT * from address LIMIT ?,?";

    private JdbcTemplate jdbcTemplate;

    // Constructor with DI
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Address createAddress(Address address) {

        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode()
                );
        
        int addressId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        address.setAddressId(addressId);

        return address;
    }

    @Override
    public Address getAddressById(Integer addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_ADDRESS,
                    new AddressMapper(),
                    addressId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Address> getAllAddresses(int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_ADDRESSES,
                new AddressMapper(), offset, limit);
    }

    @Override
    public Address updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode(),
                address.getAddressId());
        return address;
    }

    @Override
    public Address deleteAddress(Address address) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, address.getAddressId());
        return address;
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
