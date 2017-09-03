/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class ClassRosterView {
    
    private UserIO io;
    
    public ClassRosterView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");
        
        int menuSelection = io.readInt("Please select from the above choices", 1, 5);
        
        return(menuSelection);
    }
    
    public void printUnknownCommand() {
        io.print("Unknown command. Please try again.");
    }
    
    public void displayCreateStudentBanner() {
        io.print("**** Create Student ****");
    }

    public Student getNewStudentInfo() {
        
        Integer studentID = io.readInteger("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        
        Student currentStudent = new Student(studentID);
        
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        
        return currentStudent;
        
    }

    public void displayCreateStudentSuccessBanner() {
        io.readString("Student successfully created. Please hit enter to continue.");
    }
    
    public void displayStudentList(List<Student> addressList) {
        for (Student currentStudent : addressList) {
            io.print(currentStudent.getStudentID() + ": "
                + currentStudent.getFirstName() + " "
                + currentStudent.getLastName());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("**** Display All Students ****");
    }
    
    public void displayDisplayStudentBanner() {
        io.print("**** Display Student ****");
    }
    
    public Integer getStudentIDChoice() {
        return io.readInt("Please enter the Student ID.");
    }
    
    public void displayStudent(Student address) {
        if (address != null) {
            io.print(address.getStudentID());
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getCohort());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveStudentBanner () {
        io.print("**** Remove Student ****");
    }
    
    public void displayRemoveSuccessBanner () {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("**** Error ****");
        io.print(errorMsg);
    }
    
}
