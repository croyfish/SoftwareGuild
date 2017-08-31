/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentQuizScores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jeffc
 */
public class Student {
    public Map<Integer, Double> quizzes = new HashMap();
    private Set<Integer> quizKeys = quizzes.keySet();
    private String firstName;
    private String lastName;

    Student(String newFirstName, String newLastName) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }
    
    
    private void viewQuizScores() {
        
    }
    
    
    private void viewAverageQuizScore () {
        
    }
    
   
    
    public Map<Integer, Double> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Map<Integer, Double> quizzes) {
        this.quizzes = quizzes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Integer> getQuizKeys() {
        return quizKeys;
    }

    public void setQuizKeys(Set<Integer> quizKeys) {
        this.quizKeys = quizKeys;
    }
    
    
    
}
