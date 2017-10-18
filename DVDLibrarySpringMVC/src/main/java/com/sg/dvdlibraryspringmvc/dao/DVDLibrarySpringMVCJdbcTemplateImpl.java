/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.DVD;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jeffc
 */
public class DVDLibrarySpringMVCJdbcTemplateImpl implements DVDLibrarySpringMVCDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final String SQL_INSERT_DVD
        = "insert into dvd (title, releaseDate, MPAARating, "
        + "director, studio, userNote) values (?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_DVD
        = "delete from dvd where SKU = ?";

    private static final String SQL_UPDATE_DVD
        = "update dvd set title = ?, releaseDate = ?, MPAARating = ?, "
        + "director = ?, studio = ?, userNote = ?, where SKU =  ?";

    private static final String SQL_SELECT_DVD
        = "select * from dvd where SKU = ?";

    private static final String SQL_SELECT_ALL_DVDS
        = "select * from dvd";    
    
    

    @Override
    public void addDVD(DVD dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDVD(int SKU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDVD(DVD dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getDVDBySKU(int SKU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllDVDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
