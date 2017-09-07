/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class DVDLibraryView {
    
    // Declare local IO object
    private UserIO io;
    
    // Initialize local IO to IO injected by App
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    // Print the main menu and return the user's selection
    public int printMenuAndGetSelection() {
        
        io.print("\nMain Menu");
        io.print("1. Add a DVD");
        io.print("2. Delete a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List all DVDs");
        io.print("5. Display DVD Information by SKU");
        io.print("6. Search for DVD by Title");
        io.print("7. Exit");
        
        // Limit the input to integers from 1-7
        int menuSelection = io.readInt("\nPlease select from the above choices", 1, 7);
        
        return(menuSelection);
    }
    
    public void printUnknownCommand() {
        io.print("\nUnknown command. Please try again.");
    }
    
    public void displayCreateDVDBanner() {
        io.print("\n**** Create DVD ****");
    }
    
    // Ask user to fill all fields except SKU of new (or edited) DVD object
    public DVD getNewDVDInfo(String SKU) {
        
        // Read in fields
        String title = io.readString("\nPlease enter DVD title."); io.print("");
        LocalDate releaseDate = io.readLocalDate("Please enter the release date (yyyy-MM-dd)."); io.print("");
        String MPAARating = io.readString("Please enter the MPAA rating."); io.print("");
        String director = io.readString("Please enter director's name."); io.print("");
        String studio = io.readString("Please enter production studio."); io.print("");
        String userNote = io.readString("Please enter your movie rating or note."); io.print("");
        
        // Instantiate new (or edited) DVD object
        DVD currentDVD = new DVD(SKU);
        
        // Set new object's fields
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
    
    // Display info one particular DVD
    public void displayDVD(DVD dvd) {
        // Call local method to print out fields
        showDVDFields(dvd);
        io.readString("Please hit enter to continue"); io.print("");
    }    
    
    // Display all information for each DVD object in the list passed in
    public void displayDVDList(List<DVD> dvdList) {
        // Extract objects from list one by one
        for (DVD dvd : dvdList) {
            // Call local method to print out fields
            showDVDFields(dvd);
        }
        io.readString("\nPlease hit enter to continue."); io.print("");
    }
    
    // Print out all fields of information from a DVD object
    private void showDVDFields(DVD currentDVD) {
        DVD dvd = currentDVD;
        if (dvd != null) {
            io.print("\nSKU: " + dvd.getSKU());
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate().toString());
            io.print("MPAA Rating: " + dvd.getMPAARating());
            io.print("Director: " + dvd.getDirector());
            io.print("Studio: " + dvd.getStudio());
            io.print("My Ratings & Notes: " + dvd.getUserNote()); io.print("");
        } else {
            io.print("No such entry.");
        }
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
    
    // Ask user to confirm intent and return answer as a String
    public String displayAreYouSureMessageAndGetAnswer() {
        return io.readString("\nAre you sure you want to do this? (y/n)");
    }
    
    // Ask user to confirm intent and return answer as a String
    public String displayDoAgainMessageAndGetAnswer() {
        return io.readString("\nDo you want to perform this action again? (y/n)");
    }
    
    // Pause and let user view success message before continuing
    public void displayEditSuccessBanner() {
        io.readString("\nDVD Successfully Edited. Please hit enter to continue."); io.print("");
    }
    
    // Get the user's SKU choice to select a DVD object as the current one to
    // perform operations on
    public String getSKUChoice() {
        return io.readString("Please enter the SKU.");
    }
    
    // Get the user's title search choice and return it as a string
    public String getSearchTitleChoice() {
        return io.readString("Please enter the title you wish to search for.");
    }
    
    public void displayRemoveDVDBanner () {
        io.print("\n**** Remove DVD ****"); io.print("");
    }
    
    // Pause and let user view success message before continuing
    public void displayRemoveSuccessBanner () {
        io.readString("\nDVD successfully removed. Please hit enter to continue."); io.print("");
    }
    
    public void displayExitBanner() {
        io.print("\nGood Bye!!!");
    }
    
    // Pause and let user view unsuccess message before continuing
    public void displayUnknownSKUBanner() {
        io.readString("\nUnknown SKU value. Please hit enter to continue.");io.print("");
    }
    
    public void displayNoResultsBanner() {
        io.print("(no results found)");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("\nUnknown Command!!!"); io.print("");
    }
    
    // General method to display any error message passed in as a String
    public void displayErrorMessage(String errorMsg) {
        io.print("\n**** Error ****");
        io.print(errorMsg);
    }
    
}
