/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author jeffc
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();
    public static final String ADDRESS_FILE = "dvds.txt";
    public static final String DELIMITER = "::";
    private Integer nextSKU = 0;
    
    @Override
    public void initializeLibrary()
     throws DVDLibraryDaoException {
        loadLibrary();
    }

    @Override
    public DVD addDVD(String SKU, DVD dvd) 
     throws DVDLibraryDaoException {
        DVD newDVD = dvds.put(SKU, dvd);
        //writeLibrary();
        return newDVD;
    }
    
    @Override
    public DVD editDVD(String SKU, DVD editedDvd) 
     throws DVDLibraryDaoException {
        DVD currentDVD = dvds.put(SKU, editedDvd);
        //writeLibrary();
        return currentDVD;
    }

    @Override
    public List<DVD> getAllDVDs() 
     throws DVDLibraryDaoException {
        //loadLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String SKU) 
     throws DVDLibraryDaoException {
        //loadLibrary();
        return dvds.get(SKU);
    }

    @Override
    public DVD removeDVD(String SKU) 
     throws DVDLibraryDaoException {
        DVD removedDVD = dvds.remove(SKU);
        //writeLibrary();
        return removedDVD;
    }
    
    @Override
    public List<DVD> getDVDsByTitle(String title)
     throws DVDLibraryDaoException {
        loadLibrary();
        List<DVD> dvdSearchResults = new ArrayList<>();
        for (DVD currentDVD : dvds.values()) {
            if (currentDVD.getTitle().equals(title)) {
                dvdSearchResults.add(currentDVD);
            }
        }
        return (dvdSearchResults);
    }
    
    @Override
    public String getNewSKU() {
        nextSKU++;
        return ("DL" + nextSKU);
    }
    
    @Override
    public boolean verifySKU(String SKU) {
        return dvds.containsKey(SKU);
    }
    
    @Override
    public void saveOnExit() 
     throws DVDLibraryDaoException {
        writeLibrary();
    }
    
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                "-_- Could not load roster data into memory.", e);
        }
        

        String currentLine;
        if (scanner.hasNextLine()) {
          currentLine = scanner.nextLine();
            nextSKU = Integer.parseInt(currentLine);
        }
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setReleaseDate(currentTokens[2]);
            currentDVD.setMPAARating(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setUserNote(currentTokens[6]);
            
            dvds.put(currentDVD.getSKU(), currentDVD);
        }
        scanner.close();
        
    }
    
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }
        
        out.println(nextSKU);
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            out.println(currentDVD.getSKU() + DELIMITER
                    + currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMPAARating() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER 
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getUserNote());
            out.flush();
        }

        out.close();
    }
    
}
