/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.*;
import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIDException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.ui.*;
import java.util.List;


/**
 *
 * @author jeffc
 */
public class ClassRosterController {
    
    private ClassRosterServiceLayer service;
    private ClassRosterView view;

    
    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service  = service;
        this.view = view;
    }
    
    public void run() {
        
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while(keepGoing) {
            
                menuSelection = getMenuSelection();
            
                switch(menuSelection) {
                
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            
            }
            exitMessage();
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void listStudentIDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createStudent() 
     throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try{
                service.createStudent(currentStudent);
                view.displayCreateStudentSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIDException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);      
    }

    private void viewStudent()
     throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        Integer studentID = view.getStudentIDChoice();
        Student address = service.getStudent(studentID);
        view.displayStudent(address);
    }

    private void removeStudent() 
     throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        Integer studentID = view.getStudentIDChoice();
        service.removeStudent(studentID);
        view.displayRemoveSuccessBanner();
    }
    
    private void listStudents()
     throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> addressList = service.getAllStudents();
        view.displayStudentList(addressList);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
