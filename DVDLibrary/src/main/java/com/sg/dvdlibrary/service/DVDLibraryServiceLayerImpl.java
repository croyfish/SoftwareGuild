/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {
    
    private DVDLibraryDao dao;
    
    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao) {
        this.dao = dao;
    }

    @Override
    public DVD addDVD(String SKU, DVD dvd) throws DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        if (dao.getDVD(dvd.getSKU()) != null) {
            throw new DVDLibraryPersistenceException(
                    "ERROR: Could not create DVD. SKU "
            + dvd.getSKU()
            + " already exists");
        }
        
        validateDVDData(dvd);
        dao.addDVD(dvd.getSKU(), dvd);
        return dvd;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dao.getAllDVDs();
    }

    @Override
    public DVD getDVD(String SKU) throws DVDLibraryPersistenceException {
        return dao.getDVD(SKU);
    }

    @Override
    public DVD removeDVD(String SKU) throws DVDLibraryPersistenceException {
        DVD removedDVD = dao.removeDVD(SKU);
        return removedDVD;
    }

    @Override
    public List<DVD> getDVDsByTitle(String title) throws DVDLibraryPersistenceException {
        return dao.getDVDsByTitle(title);
    }

    @Override
    public boolean verifySKU(String SKU) throws DVDLibraryPersistenceException {
        return dao.verifySKU(SKU);
    }

    @Override
    public String getNewSKU() throws DVDLibraryPersistenceException {
        return dao.getNewSKU();
    }

    @Override
    public void saveOnExit() throws DVDLibraryPersistenceException {
        dao.saveOnExit();
    }
    
 private void validateDVDData(DVD dvd) throws
            DVDLibraryDataValidationException {
        
        if (dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getReleaseDate() == null
                || dvd.getReleaseDate().toString().trim().length() == 0
                || dvd.getMPAARating() == null
                || dvd.getMPAARating().trim().length() == 0
                || dvd.getDirector() == null
                || dvd.getDirector().trim().length() == 0                
                || dvd.getStudio() == null
                || dvd.getStudio().trim().length() == 0                
                || dvd.getUserNote() == null
                || dvd.getUserNote().trim().length() == 0 ) {
            
            throw new DVDLibraryDataValidationException(
                    "ERROR: All fields [Title, Release Date, MPAA Rating, Director, Studio, and User Note] are required.");
        }
    }    
    
}
