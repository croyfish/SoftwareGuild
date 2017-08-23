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
public class YourLifeInMovies {
    public static void main(String[] args) {
        
        String userName;
        int userBirthYear;
        
        Scanner readInput = new Scanner(System.in);
        
        System.out.print("Hey, let's play a game! What's your name? ");
        userName = readInput.nextLine();
        System.out.println();
        System.out.print("Okay, " + userName + ", what year were you born? ");
        userBirthYear = readInput.nextInt();
        readInput.nextLine();
        System.out.println();
        System.out.println("Well " + userName + "...");
        
        if (userBirthYear < 2005) {
        System.out.println("Did you know that Pixar's 'Up' came out half a decade ago?");
        }
        
        if (userBirthYear < 1995) {
        System.out.println("And that the first Harry Potter came out over 15 yearsa ago!");
        }
        
        if (userBirthYear < 1985) {
        System.out.println("Also, Space Jame came out not last decade, but the one before THAT.");
        }
        
        if (userBirthYear < 1975) {
        System.out.println("Not only that, but the original Jurassic Park release is closer to the lunar landing than it is to today!");
        }
        
        if (userBirthYear < 1965) {
        System.out.println("One more thing I'd like you to know. The television series *MASH* has been around for almost half a century!");
        }
    }
}
