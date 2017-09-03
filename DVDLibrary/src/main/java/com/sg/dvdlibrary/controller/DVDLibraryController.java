/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.*;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.*;
import java.util.List;


/**
 *
 * @author jeffc
 */
public class DVDLibraryController {
    
    DVDLibraryDao dao;
    DVDLibraryView view;

    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao  = dao;
        this.view = view;
    }
    
    public void run() {
        
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            initializeLibrary();
            while(keepGoing) {
            
                menuSelection = getMenuSelection();
            
                switch(menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        searchByTitle();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();                
                }
            
            }
            exitMessage();
            dao.saveOnExit();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    
    private void initializeLibrary() 
     throws DVDLibraryDaoException {
        dao.initializeLibrary();
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private boolean verifyChoice() {
        boolean confirm = true;
        String answer = view.displayAreYouSureMessageAndGetAnswer();
        if (answer.equalsIgnoreCase("n")) {
            confirm = false;
        } else if (!answer.equalsIgnoreCase("y")) {
            view.displayUnknownCommandBanner();
            confirm = false;
        }
        return confirm;
    }
    
    private void createDVD() 
     throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        if (verifyChoice() == false) {
         return;
        }
        String SKU = dao.getNewSKU();
        DVD newDVD = view.getNewDVDInfo(SKU);
        dao.addDVD(newDVD.getSKU(), newDVD);
        view.displayCreateDVDSuccessBanner(SKU);
    }

    private void viewDVD()
     throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String SKU = view.getSKUChoice();
        if (dao.verifySKU(SKU) == false) {
            view.displayUnknownSKUBanner();
            return;
        }
        DVD dvd = dao.getDVD(SKU);
        view.displayDVD(dvd);
    }

    private void removeDVD() 
     throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String SKU = view.getSKUChoice();
        if (dao.verifySKU(SKU) == false) {
            view.displayUnknownSKUBanner();
            return;
        }
        DVD currentDVD = dao.getDVD(SKU);
        view.displayDVD(currentDVD);        
        if (verifyChoice() == false) {
            return;
        }     
        dao.removeDVD(SKU);
        view.displayRemoveSuccessBanner();
    }
    
    private void listDVDs()
     throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    private void editDVD()
     throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String SKU = view.getSKUChoice();
        if (dao.verifySKU(SKU) == false) {
            view.displayUnknownSKUBanner();
            return;
        }
        DVD currentDVD = view.getNewDVDInfo(SKU);
        view.displayDVD(currentDVD);
        if (verifyChoice() == false) {
            return;
        }
        dao.editDVD(SKU, currentDVD);
        view.displayEditSuccessBanner();
    }
    
    private void searchByTitle() 
     throws DVDLibraryDaoException {
        view.displaySearchByTitleBanner();
        String title = view.getSearchTitleChoice();
        List<DVD> titleResults = dao.getDVDsByTitle(title);
        view.displayDisplaySearchByTitleResultsBanner();
        if (titleResults.size() == 0) {
            view.displayNoResultsBanner();
        }
        view.displayDVDList(titleResults);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
