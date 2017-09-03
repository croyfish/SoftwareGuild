/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class DVDLibraryView {
    
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        
        io.print("\nMain Menu");
        io.print("1. Add a DVD");
        io.print("2. Delete a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List all DVDs");
        io.print("5. Display DVD Information by SKU");
        io.print("6. Search for DVD by Title");
        io.print("7. Exit");
        
        int menuSelection = io.readInt("\nPlease select from the above choices", 1, 7);
        
        return(menuSelection);
    }
    
    public void printUnknownCommand() {
        io.print("\nUnknown command. Please try again.");
    }
    
    public void displayCreateDVDBanner() {
        io.print("\n**** Create DVD ****");
    }

    public DVD getNewDVDInfo(String SKU) {
        
        String title = io.readString("\nPlease enter DVD title."); io.print("");
        String releaseDate = io.readString("Please enter the release date."); io.print("");
        String MPAARating = io.readString("Please enter the MPAA rating."); io.print("");
        String director = io.readString("Please enter director's name."); io.print("");
        String studio = io.readString("Please enter production studio."); io.print("");
        String userNote = io.readString("Please enter your movie rating or note."); io.print("");
        
        DVD currentDVD = new DVD(SKU);
        
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNote(userNote);
        
        return currentDVD;
        
    }

    public void displayCreateDVDSuccessBanner(String SKU) {
        io.print("\nDVD created successfully and assigned SKU: " + SKU);
        io.readString("Please hit enter to continue."); io.print("");
    }
    
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD dvd : dvdList) {
            io.print("SKU: " + dvd.getSKU());
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMPAARating());
            io.print("Director: " + dvd.getDirector());
            io.print("Studio: " + dvd.getStudio());
            io.print("My Ratings & Notes: " + dvd.getUserNote()); io.print("");
        }
        io.readString("\nPlease hit enter to continue."); io.print("");
    }
    
    public void displayDisplayAllBanner() {
        io.print("\n**** Display All DVDs ****"); io.print("");
    }
    
    public void displayDisplayDVDBanner() {
        io.print("\n**** Display DVD ****"); io.print("");
    }
    
    public void displaySearchByTitleBanner() {
        io.print("\n**** Search By Title ****"); io.print("");
    }
    
    public void displayDisplaySearchByTitleResultsBanner() {
        io.print("\n**** Display Search Results ****"); io.print("");
    }
    
    public void displayEditDVDBanner() {
        io.print("\n**** Edit DVD Information ****"); io.print("");
    }
    
    public String displayAreYouSureMessageAndGetAnswer() {
        return io.readString("\nAre you sure you want to do this? (y/n)");
    }
    
    public void displayEditSuccessBanner() {
        io.readString("\nDVD Successfully Edited. Please hit enter to cointinue."); io.print("");
    }
    
    public String getSKUChoice() {
        return io.readString("Please enter the SKU.");
    }
    
    public String getSearchTitleChoice() {
        return io.readString("Please enter the title you wish to search for.");
    }
    
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print("\nSKU: " + dvd.getSKU());
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMPAARating());
            io.print("Director: " + dvd.getDirector());
            io.print("Studio: " + dvd.getStudio());
            io.print("My Ratings & Notes: " + dvd.getUserNote()); io.print("");
        } else {
            io.print("No such entry.");
        }
        io.readString("Please hit enter to continue"); io.print("");
    }
    
    public void displayRemoveDVDBanner () {
        io.print("\n**** Remove DVD ****"); io.print("");
    }
    
    public void displayRemoveSuccessBanner () {
        io.readString("\nDVD successfully removed. Please hit enter to continue."); io.print("");
    }
    
    public void displayExitBanner() {
        io.print("\nGood Bye!!!");
    }
    
    public void displayUnknownSKUBanner() {
        io.readString("\nUnknown SKU value. Please hit enter to continue.");io.print("");
    }
    
    public void displayNoResultsBanner() {
        io.print("(no results found)");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("\nUnknown Command!!!"); io.print("");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("\n**** Error ****");
        io.print(errorMsg);
    }
    
}
