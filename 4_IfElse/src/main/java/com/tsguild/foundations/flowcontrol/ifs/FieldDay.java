/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class FieldDay {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        
        System.out.print("What's your last name? ");
        String lastName = readInput.nextLine(), team = "Black Holes";
        
        int compare = lastName.compareTo("Vimes");
        
        if (compare < 0) {
            team = "Night Guards";
        } 
        
        compare = lastName.compareTo("Potter");
        
        if (compare < 0) {
            team = "Golden Snitches";
        } 
        
        compare = lastName.compareTo("Howl");
        
         if (compare < 0) {
            team = "Moving Castles";
        } 
         
        compare = lastName.compareTo("Dresden");
        
        if (compare < 0) {
            team = "Dark Wizards";
        }  
        
        compare = lastName.compareTo("Baggins");
        
        if (compare < 0) {
            team = "Red Dragons";
        }
        
        System.out.println("Aha! You're on the team \"" + team + "\"!");
        System.out.println("Good luck in the games!");
        
    }
    
}
