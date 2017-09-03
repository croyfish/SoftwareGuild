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
     throws DVDLibraryDaoException;
    
    public DVD editDVD(String SKU, DVD dvd)
     throws DVDLibraryDaoException;
    
    public List<DVD> getAllDVDs()
     throws DVDLibraryDaoException;
    
    public DVD getDVD(String SKU)
     throws DVDLibraryDaoException;
    
    public DVD removeDVD(String SKU)
     throws DVDLibraryDaoException;
    
    public List<DVD> getDVDsByTitle(String title)
     throws DVDLibraryDaoException;
    
    public boolean verifySKU(String SKU)
     throws DVDLibraryDaoException;
    
    public String getNewSKU();
    
    public void initializeLibrary()
     throws DVDLibraryDaoException;

    public void saveOnExit()
     throws DVDLibraryDaoException;
    
}
