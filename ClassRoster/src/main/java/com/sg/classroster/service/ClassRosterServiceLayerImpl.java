/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;
import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterDataValidationException;
import com.sg.classroster.service.ClassRosterDuplicateIDException;
import com.sg.classroster.service.ClassRosterServiceLayer;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class ClassRosterServiceLayerImpl implements
        ClassRosterServiceLayer {
    
    private ClassRosterAuditDao auditDao;
    ClassRosterDao dao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws 
            ClassRosterDuplicateIDException, 
            ClassRosterDataValidationException, 
            ClassRosterPersistenceException {
        
        if (dao.getStudent(student.getStudentID()) != null) {
            throw new ClassRosterDuplicateIDException(
                    "ERROR: Could not create student. Student ID "
            + student.getStudentID()
            + " already exists");
        }
        
        validateStudentData(student);
        dao.addStudent(student.getStudentID(), student);
        auditDao.writeAuditEntry(
                "Student " + student.getStudentID() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudents() throws 
            ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(Integer studentID) throws 
            ClassRosterPersistenceException {
        return dao.getStudent(studentID);
    }

    @Override
    public Student removeStudent(Integer studentID) throws 
            ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentID);
        auditDao.writeAuditEntry("Student " + studentID + " REMOVED.");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {
        
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {
            
            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
    
}
