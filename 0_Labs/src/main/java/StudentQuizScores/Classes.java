/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentQuizScores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jeffc
 */
public class Classes {
    
    UserIO IO = new UserIOImpl();
    String firstName, lastName;
    List<Student> addresses = new ArrayList<>();
    Student currentStudent;
    boolean has = false;
    int addressIndex = -1;

    
    public void readData() {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("StudentQuizzes.txt")));
            while(sc.hasNextLine()) {

                String currentLine = sc.nextLine();
                String delims = "[::]+";
                String[] tokens = currentLine.split(delims);
                
                /*
                for (String nextToken : tokens) {
                    IO.print(nextToken);
                }*/
                firstName = tokens[0];
                lastName = tokens[1];
                
                currentStudent = new Student(firstName, lastName);
                addresses.add(currentStudent);
                for (int i = 2; i < tokens.length; i++) {
                    double currentScore = Double.parseDouble(tokens[i]);
                    currentStudent.quizzes.put(i-1, currentScore);
                }
            }
        } catch (IOException ex) {
            IO.print("Your data have been corrupted. Stop letting them stay out late at night.");
        }        
    }
    
    public void saveData() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("StudentQuizzes.txt"));
            for (Student currentStudent : addresses) {
                out.print(currentStudent.getFirstName());
                out.print("::");
                out.print(currentStudent.getLastName());
                out.print("::");
            
                for (int quiz : currentStudent.getQuizKeys()) {
                    out.print(currentStudent.quizzes.get(quiz));
                    out.print("::");
                }
            
                out.println("");
            
            } 
            
            out.flush();
            out.close();
            
        } catch (IOException ex) {
            IO.print("No write file exists. Error #693883");
            }
        
    } 
    
    public void addNewStudent() {
        firstName = IO.readString("Enter the first name: ");
        lastName = IO.readString("Enter the last name: ");
        has = this.hasStudent(firstName, lastName);
        if (has) {
            IO.print("That name is already there, ya dingus!");
        } else {
            Student newStudent = new Student(firstName, lastName);
            addresses.add(newStudent);
            newStudent.quizzes.put(1, 95.23d);
            newStudent.quizzes.put(2, 77.98d);
            newStudent.quizzes.put(3, 86.17d);
            IO.print("New address successfully added.");
        }        
    }
    
    public boolean hasStudent(String fN, String lN) {
        firstName = fN; 
        lastName = lN;
        
        has = false;
            
        for (int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).getFirstName().equals(firstName) && addresses.get(i).getLastName().equals(lastName)) {
                has = true;
            }
        }
            
        return has;
    }

    public void removeStudent() {
        firstName = IO.readString("Enter the first name: ");
        lastName = IO.readString("Enter the last name: ");
        has = hasStudent(firstName, lastName);
        if (!has) {
            IO.print("That name isn't there, meathead!");
        } else {
            addressIndex = getStudentIndex(firstName, lastName);
            addresses.remove(addressIndex);
            IO.print("New address successfully removed.");
        }        
    }
    
    public int getStudentIndex(String fN, String lN) {
        firstName = fN;
        lastName = lN;
        
        int index = 0;
        
        for (int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).getFirstName().equals(firstName) && addresses.get(i).getLastName().equals(lastName)) {
               index = i;
            }
        }
            
        return index;
    }

    public void viewQuizScores() {
        firstName = IO.readString("Enter the first name: ");
        lastName = IO.readString("Enter the last name: ");
        has = hasStudent(firstName, lastName);
        if (!has) {
            IO.print("That name isn't there, goofball!");
        } else {
            addressIndex = getStudentIndex(firstName, lastName);
            currentStudent = addresses.get(addressIndex);
                        
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
    }
    
    public void viewAveQuizScore() {
        firstName = IO.readString("Enter the first name: ");
        lastName = IO.readString("Enter the last name: ");
        has = hasStudent(firstName, lastName);
        if (!has) {
            IO.print("That name isn't there, goofball!");
        } else {
            addressIndex = getStudentIndex(firstName, lastName);
            currentStudent = addresses.get(addressIndex);
                        
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
    }

    public void viewStudentList() {
        IO.print("The Students are:");
        IO.print("=================");
        for (Student currentStudent : addresses) {
            System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());
        }        
        
    }
    
}


