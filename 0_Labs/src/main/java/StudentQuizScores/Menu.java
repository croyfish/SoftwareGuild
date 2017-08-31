/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentQuizScores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Random;

/**
 *
 * @author jeffc
 */
public class Menu {
    
    UserIO IO = new UserIOImpl();
    List<Student> students = new ArrayList<>();
    Student currentStudent;
    Random randomizer = new Random();
    
    
    public void displayMenu() {
        
        int userChoice = 0, studentIndex = -1;
        String firstName, lastName;
        boolean has;
        
        while (userChoice != 6) {
        
            IO.print("");
            IO.print("Choose your Quest: ");
            IO.print("1: View Student List");
            IO.print("2: Add New Student");
            IO.print("3: Remove Student");
            IO.print("4: View List of Student Quiz Scores");
            IO.print("5: View Average Quiz Scores for One Student");
            IO.print("6: Exit");
            
            userChoice = IO.readInt("", 1, 6);
            
            switch (userChoice) {
                case 1:
                    IO.print("The Students are:");
                    IO.print("=================");
                    for (Student currentStudent : students) {
                        System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());
                    }
                    break;
                    
                case 2:
                    firstName = IO.readString("Enter the first name: ");
                    lastName = IO.readString("Enter the last name: ");
                    has = hasStudent(firstName, lastName);
                    if (has) {
                        IO.print("That name is already there, ya dingus!");
                    } else {
                        Student newStudent = new Student(firstName, lastName);
                        students.add(newStudent);
                        newStudent.quizzes.put(1, 95.23d);
                        newStudent.quizzes.put(2, 77.98d);
                        newStudent.quizzes.put(3, 86.17d);
                        IO.print("New student successfully added.");
                    }
                    break;
                    
                case 3:
                    firstName = IO.readString("Enter the first name: ");
                    lastName = IO.readString("Enter the last name: ");
                    has = hasStudent(firstName, lastName);
                    if (!has) {
                        IO.print("That name isn't there, meathead!");
                    } else {
                        studentIndex = getStudentIndex(firstName, lastName);
                        students.remove(studentIndex);
                        IO.print("New student successfully removed.");
                    }
                    break;
                                   
                case 4:
                    firstName = IO.readString("Enter the first name: ");
                    lastName = IO.readString("Enter the last name: ");
                    has = hasStudent(firstName, lastName);
                    if (!has) {
                        IO.print("That name isn't there, goofball!");
                    } else {
                        studentIndex = getStudentIndex(firstName, lastName);
                        currentStudent = students.get(studentIndex);
                        
                        IO.print("");
                        System.out.println("The quiz scores for " + currentStudent.getFirstName() 
                                + " " + currentStudent.getLastName() + " are:");
                        Set<Integer> quizKeys = currentStudent.getQuizKeys();
                        
                        for (int index : quizKeys) {
                            System.out.println("Quiz " + index);
                            IO.print(currentStudent.quizzes.get(index) + " ");
                        }
                        
                        IO.print("");
                    }
                    break;

                case 5:
                    firstName = IO.readString("Enter the first name: ");
                    lastName = IO.readString("Enter the last name: ");
                    has = hasStudent(firstName, lastName);
                    if (!has) {
                        IO.print("That name isn't there, goofball!");
                    } else {
                        studentIndex = getStudentIndex(firstName, lastName);
                        currentStudent = students.get(studentIndex);
                        
                        System.out.println("The average quiz score for " + currentStudent.getFirstName() + " " + 
                                currentStudent.getLastName() + " is: ");
                        Set<Integer> quizKeys = currentStudent.getQuizKeys();
                        
                        int numberOfQuizzes = 0;
                        double sumOfQuizzes = 0;
                        
                        for (int index : quizKeys) {
                            numberOfQuizzes++;
                            sumOfQuizzes += currentStudent.quizzes.get(index);
                        }
                        
                        System.out.println(sumOfQuizzes / numberOfQuizzes);
                    }
                    break;

            }
        } 
        IO.print("Thanks for playing. See you again!");
    }
    
    
    public boolean hasStudent(String fN, String lN) {
        String firstName = fN, lastName = lN;
        
        boolean has = false;
            
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)) {
                has = true;
            }
        }
            
        return has;
    }
        
    public int getStudentIndex(String fN, String lN) {
        String firstName = fN, lastName = lN;
        
        int index = 0;
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)) {
               index = i;
            }
        }
            
        return index;
    }
        
}
