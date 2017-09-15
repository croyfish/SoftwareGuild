/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public interface DVDLibraryDao {
    
    public DVD addDVD(String SKU, DVD dvd)
     throws DVDLibraryPersistenceException;
    
    public DVD editDVD(String SKU, DVD dvd)
     throws DVDLibraryPersistenceException;
    
    public List<DVD> getAllDVDs()
     throws DVDLibraryPersistenceException;
    
    public DVD getDVD(String SKU)
     throws DVDLibraryPersistenceException;
    
    public DVD removeDVD(String SKU)
     throws DVDLibraryPersistenceException;
    
    public List<DVD> getDVDsByTitle(String title)
     throws DVDLibraryPersistenceException;
    
    public boolean verifySKU(String SKU)
     throws DVDLibraryPersistenceException;
    
    public String getNewSKU() 
     throws DVDLibraryPersistenceException;

    public void saveOnExit()
     throws DVDLibraryPersistenceException;
    
    public List<DVD> getAllMoviesReleasedInLastNYears(int N)
     throws DVDLibraryPersistenceException;
    
    public List<DVD> getAllMoviesWithGivenMPAARating(String MPAARating)
     throws DVDLibraryPersistenceException;
    
    public Map<String, List<DVD>> getAllMoviesByGivenDirectorSortedByMPAARating(String Director)
     throws DVDLibraryPersistenceException;
    
    public List<DVD> getAllMoviesReleasedByStudio(String Studio)
     throws DVDLibraryPersistenceException;
    
    public double getAverageAgeOfAllMovies()
     throws DVDLibraryPersistenceException;
    
    public List<DVD> getNewestMovie()
     throws DVDLibraryPersistenceException;;
    
    public List<DVD> getOldestMovie()
     throws DVDLibraryPersistenceException;
    
    public double getAverageNumberOfNotesPerMovie()
     throws DVDLibraryPersistenceException;
    
    public List<DVD> getListOfDVDs () 
     throws DVDLibraryPersistenceException;       
    }
