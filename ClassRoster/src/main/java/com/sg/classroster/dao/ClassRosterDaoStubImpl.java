/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao {
    
    Student onlyStudent;
    List<Student> studentList = new ArrayList<>();
    
    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student(1);
        onlyStudent.setFirstName("John");
        onlyStudent.setLastName("Doe");
        onlyStudent.setCohort("Java-Jan-2015");
        
        studentList.add(onlyStudent);
    }

    @Override
    public Student addStudent(Integer studentID, Student student) throws ClassRosterPersistenceException {
        if (studentID.equals(onlyStudent.getStudentID())) {
            return onlyStudent;
        } else {
            return null;           
        }
    }
    
    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return studentList;
    }
    
    @Override
    public Student getStudent(Integer studentID) throws ClassRosterPersistenceException {
        if (studentID.equals(onlyStudent.getStudentID())) {
            return onlyStudent;
        } else {
            return null;           
        }        
    }

    @Override
    public Student removeStudent(Integer studentID) throws ClassRosterPersistenceException {
        if (studentID.equals(onlyStudent.getStudentID())) {
            return onlyStudent;
        } else {
            return null;           
        }          
    }
    
}
