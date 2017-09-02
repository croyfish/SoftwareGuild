/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentQuizScores;

import java.util.ArrayList;
import java.util.List;
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
        Classes classes = new Classes();
        
        classes.readData();
        
        while (userChoice != 7) {
        
            IO.print("");
            IO.print("Choose your Quest: ");
            IO.print("1: View Student List");
            IO.print("2: Add New Student");
            IO.print("3: Remove Student");
            IO.print("4: View List of Student Quiz Scores");
            IO.print("5: View Average Quiz Scores for One Student");
            IO.print("6: Save Data to File");
            IO.print("7: Exit");
            
            userChoice = IO.readInt("", 1, 7);
            
            switch (userChoice) {
                case 1: //View Student List
                    classes.viewStudentList();
                    break;
                    
                case 2: //Add New Student
                    classes.addNewStudent();
                    break;
                    
                case 3: //Remove Student
                    classes.removeStudent();
                    break;
                                   
                case 4: // View List of Student Quiz Scores
                    classes.viewQuizScores();
                    break;

                case 5: // View Average Quiz Scores for One Student
                    classes.viewAveQuizScore();
                    break;
                    
                case 6: // Save Data to File
                    classes.saveData();
                    break;
            }
        } 
        IO.print("Thanks for playing. See you again!");
        classes.saveData();
        IO.print("Your data have been saved automatically.");
        IO.print("You're welcome.");
    }
}
    


