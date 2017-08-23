/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.scanner;

import java.util.Scanner;
/**
 *Ask the user for how many miles they can run, 
 * the number of hotdogs they can eat, 
 * and the number of languages they know. 
 * Immediately after each question, 
 * brag that you can do more by multiplying it by 2 and adding 1.
 * @author jeffc
 */
public class DoItBetter {
    public static void main(String[] args) {
        
        Scanner inputReaderD = new Scanner(System.in);
        int milesRun, hotdogsEaten, languagesKnown;
        
        System.out.print("How many miles can you run? ");
        milesRun = inputReaderD.nextInt();
        inputReaderD.nextLine();
        
        System.out.println("That's nothing. I can run " + ((milesRun * 2) + 1) + " miles!");
        
        System.out.print("How many hotdogs can you eat? ");
        hotdogsEaten = inputReaderD.nextInt();
        inputReaderD.nextLine();
        
        System.out.println("That's nothing. I can eat " + ((hotdogsEaten * 2) + 1) + " hotdogs!");
        
        System.out.print("How many languages do you know? ");
        languagesKnown = inputReaderD.nextInt();
        inputReaderD.nextLine();
        
        System.out.println("That's nothing. I know " + ((languagesKnown * 2) + 1) + " languages!");
    }
}
