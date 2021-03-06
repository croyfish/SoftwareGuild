/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public class DVDLibraryDaoStubImpl implements DVDLibraryDao {

    DVD dvd1, dvd2, dvd3;
    List<DVD> DVDList = new ArrayList<>();
    int nextSKU;
    
    public DVDLibraryDaoStubImpl() {
        dvd1 = new DVD("DL1");
        dvd1.setTitle("Happy Days");
        dvd1.setReleaseDate(LocalDate.parse("2010-02-07"));
        dvd1.setMPAARating("PG-27");
        dvd1.setDirector("The Fonz");
        dvd1.setStudio("Hollywood");
        dvd1.setUserNote("This is fun and funny.");
        
        DVDList.add(dvd1);
        
        dvd2 = new DVD("DL2");
        dvd2.setTitle("Happy Days");
        dvd2.setReleaseDate(LocalDate.parse("2010-02-07"));
        dvd2.setMPAARating("PG-29");
        dvd2.setDirector("The Fonzerelli");
        dvd2.setStudio("Hollywood, Los Angeles");
        dvd2.setUserNote("This is fun and the funniest.");
        
        DVDList.add(dvd2);

        dvd3 = new DVD("DL3");
        dvd3.setTitle("Unhappy Days");
        dvd3.setReleaseDate(LocalDate.parse("2010-02-07"));
        dvd3.setMPAARating("PG-33");
        dvd3.setDirector("The Fonzerellieliiili");
        dvd3.setStudio("Hollywood, Los Angeles, CA");
        dvd3.setUserNote("This is fun and the funniest and so, so funny.");
        
        DVDList.add(dvd3);
        
        nextSKU = 3;
    }
    
    @Override
    public DVD addDVD(String SKU, DVD dvd) throws DVDLibraryPersistenceException {
        if(SKU.equals(dvd1.getSKU())) {
            return dvd1;
        } else {
            return null;
        }
    }
    
    @Override
    public DVD editDVD(String SKU, DVD dvd) throws DVDLibraryPersistenceException {
        if(SKU.equals(dvd1.getSKU())) {
            return dvd1;
        } else {
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return DVDList;
    }

    @Override
    public DVD getDVD(String SKU) throws DVDLibraryPersistenceException {
        if (SKU.equals(dvd1.getSKU())) {
            return dvd1;
        } else {
            return null;
        }
    }

    @Override
    public DVD removeDVD(String SKU) throws DVDLibraryPersistenceException {
        if (SKU.equals(dvd1.getSKU())) {
            return dvd1;
        } else {
            return null;
        }        
    }

    @Override
    public List<DVD> getDVDsByTitle(String title) throws DVDLibraryPersistenceException {
        
        List<DVD> searchResults = new ArrayList<>();
        for (DVD currentDVD : DVDList) {
            if (title.equals(currentDVD.getTitle())) {
                searchResults.add(currentDVD);
            }
        }
        return searchResults;
    }

    @Override
    public boolean verifySKU(String SKU) throws DVDLibraryPersistenceException {
        for (DVD currentDVD : DVDList) {
            if (currentDVD.getSKU().equals(SKU)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getNewSKU() {
        nextSKU++;
        return ("DL" + nextSKU);
    }

    @Override
    public void saveOnExit() throws DVDLibraryPersistenceException {
        return;
    }

    @Override
    public List<DVD> getAllMoviesReleasedInLastNYears(int N) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllMoviesWithGivenMPAARating(String MPAARating) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, List<DVD>> getAllMoviesByGivenDirectorSortedByMPAARating(String Director) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllMoviesReleasedByStudio(String Studio) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAverageAgeOfAllMovies() throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getNewestMovie() throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getOldestMovie() throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAverageNumberOfNotesPerMovie() throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getListOfDVDs() throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void loadLibrary() {
        
    }
    
}
