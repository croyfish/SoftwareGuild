/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface DVDLibraryDao {
    
    public DVD addDVD(String SKU, DVD dvd)
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
    
}
