/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public interface DVDLibrarySpringMVCDao {
    
    public void addDVD(DVD dvd);
    
    public void deleteDVD(int SKU);
    
    public void updateDVD(DVD dvd);
    
    public DVD getDVDBySKU(int SKU);
    
    public List<DVD> getAllDVDs();
    
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);

}
