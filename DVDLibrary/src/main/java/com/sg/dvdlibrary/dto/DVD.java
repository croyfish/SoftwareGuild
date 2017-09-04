/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author jeffc
 */

// DVD object that holds all of the program's data and acts as the only type of DTO
public class DVD {
    
    // Fields for DVD object
    private String SKU;
    private String title;
    private String releaseDate;
    private String MPAARating;
    private String director;
    private String studio;
    private String userNote;

    // Constructor for DVD object -- requires a unique SKU
    public DVD(String SKU) {
        this.SKU = SKU;
    }

    // SKU for each DVD object is read-only, because it is the unique identifier
    public String getSKU() {
        return SKU;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
