/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

/**
 *
 * @author jeffc
 */

// This class handles exceptions caused by the DAO
public class DVDLibraryDaoException extends Exception{
    
    // Revert to super-class's exception handling
    public DVDLibraryDaoException(String message) {
        super(message);
    }
    
    // Revert to super-class's exception handling
    public DVDLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
