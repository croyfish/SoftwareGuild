/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.DVD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

//    private static final String SQL_SELECT_DVDS_BY_CRITERIA
//            = "select * from dvd where title = ? or releaseDate = ?"
//            + " or MPAARating = ? or director = ? or studio = ? or SKU = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addDVD(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                java.sql.Date.valueOf(dvd.getReleaseDate()),
                dvd.getMPAARating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserNote());

        String sku
                = Integer.toString(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class));

        dvd.setSKU(sku);
    }

    @Override
    public void deleteDVD(int sku) {
        jdbcTemplate.update(SQL_DELETE_DVD, sku);
    }

    @Override
    public void updateDVD(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                java.sql.Date.valueOf(dvd.getReleaseDate()),
                dvd.getMPAARating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserNote(),
                dvd.getSKU());
    }

    @Override
    public DVD getDVDBySKU(int sku) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD,
                    new DVDMapper(),
                    sku);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVDs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS,
                new DVDMapper());
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {

        if (criteria.isEmpty()) {
            return getAllDVDs();
        } else {
            // build a prepared statement based on the user's search
            // terms
            StringBuilder sQuery
                    = new StringBuilder("select * from dvd where ");
            // build the where clause
            int numParams = criteria.size();
            int paramPosition = 0;
            // we'll put the positional parameters into an array, the 
            // order of the parameters will match the order in which we 
            // get the search criteria from the map
            String[] paramVals = new String[numParams];
            Set<SearchTerm> keySet = criteria.keySet();
            Iterator<SearchTerm> iter = keySet.iterator();
            // build up the where clause based on the key/value pairs in 
            // the map build where clause and positional parameter array
            while (iter.hasNext()) {
                SearchTerm currentKey = iter.next();
                // if we are not the first one in, we must add an AND to 
                // the where clause
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                // now append our criteria name
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                // grab the value for this search criteria and put it into 
                // the paramVals array
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }

            return jdbcTemplate.query(sQuery.toString(),
                    new DVDMapper(),
                    paramVals);
        }
    }

    private static final class DVDMapper implements RowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            dvd.setSKU(Integer.toString(rs.getInt("SKU")));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getTimestamp("ReleaseDate").
                    toLocalDateTime().toLocalDate());
            dvd.setMPAARating("MPAARating");
            dvd.setDirector(rs.getString("director"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setUserNote(rs.getString("userNote"));
            return dvd;
        }
    }

}
