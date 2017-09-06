/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface ClassRosterDao {
    
    public Student addStudent(Integer studentID, Student student)
     throws ClassRosterPersistenceException;
    
    public List<Student> getAllStudents()
     throws ClassRosterPersistenceException;
    
    public Student getStudent(Integer studentID)
     throws ClassRosterPersistenceException;
    
    public Student removeStudent(Integer studentID)
     throws ClassRosterPersistenceException;
    
}
