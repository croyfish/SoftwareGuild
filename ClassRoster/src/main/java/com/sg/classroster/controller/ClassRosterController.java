/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.*;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.*;
import java.util.List;


/**
 *
 * @author jeffc
 */
public class ClassRosterController {
    
    ClassRosterDao dao;
    ClassRosterView view;

    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao  = dao;
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
        } catch (ClassRosterDaoException e) {
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
     throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentID(), newStudent);
        view.displayCreateStudentSuccessBanner();
    }

    private void viewStudent()
     throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        Integer studentID = view.getStudentIDChoice();
        Student address = dao.getStudent(studentID);
        view.displayStudent(address);
    }

    private void removeStudent() 
     throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        Integer studentID = view.getStudentIDChoice();
        dao.removeStudent(studentID);
        view.displayRemoveSuccessBanner();
    }
    
    private void listStudents()
     throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> addressList = dao.getAllStudents();
        view.displayStudentList(addressList);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
