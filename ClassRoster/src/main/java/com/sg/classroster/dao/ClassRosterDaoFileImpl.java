/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
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
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    private Map<Integer, Student> students = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public Student addStudent(Integer studentID, Student address) 
     throws ClassRosterDaoException {
        Student newStudent = students.put(studentID, address);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() 
     throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList(students.values());
    }

    @Override
    public Student getStudent(Integer studentID) 
     throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentID);
    }

    @Override
    public Student removeStudent(Integer studentID) 
     throws ClassRosterDaoException {
        Student removedStudent = students.remove(studentID);
        writeRoster();
        return removedStudent;
    }
    
    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException(
                "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Student currentStudent = new Student(Integer.parseInt(currentTokens[0]));
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);
            
            students.put(currentStudent.getStudentID(), currentStudent);
        }
        
        scanner.close();
    }
    
    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException(
                    "Could not save address data.", e);
        }
        
        List<Student> addressList = this.getAllStudents();
        for (Student currentStudent : addressList) {
            out.println(currentStudent.getStudentID() + DELIMITER
                    + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());
            out.flush();
        }
        
        out.close();
    }
    
}
