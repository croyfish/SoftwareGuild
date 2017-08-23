/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author jeffc
 * 1,024 Gigabytes is equal to one what? Terabyte
In our solar system which is the only planet that rotates clockwise? Venus
The largest volcano ever discovered in our solar system is located on which planet? Mars
What is the most abundant element in the earth's atmosphere? Nitrogen

Wow, 1,024 Gigabytes is a Mars!
I didn't know that the largest ever volcano was discovered on Terabyte!
That's amazing that Venus is the most abundant element in the atmosphere...
Nitrogen is the only planet that rotates clockwise, neat!
 */
public class AllTheTrivia {
    public static void main(String[] args) {
        
        Scanner inputReaderC = new Scanner(System.in);
        
        int months, year;
        String continent, inventor;
        
        System.out.print("How many months are in a year? ");
        months = inputReaderC.nextInt();
        inputReaderC.nextLine();
        
        System.out.print("What continent is Tajikistan on? ");
        continent = inputReaderC.nextLine();
        
        System.out.print("What year did Led Zeppelin IV come out? ");
        year = inputReaderC.nextInt();
        inputReaderC.nextLine();

        System.out.print("Who invented the lightbulb? ");
        inventor = inputReaderC.nextLine();
        

        
        System.out.println(" ");
        System.out.println("Wow, " + continent + " invented the light bulb.");
        System.out.println("I didn't know that there are " + year + " months in a year");
        System.out.println("That's amazing that Tajikistan was invented in " + months);
        System.out.println(inventor + " was the lead singer of Led Zeppelin. Neat!");
        
                
        
    }
           
}
