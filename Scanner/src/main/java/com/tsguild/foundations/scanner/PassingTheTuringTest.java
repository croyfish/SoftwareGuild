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
 * Filename: PassingTheTuringTest.java
 */
public class PassingTheTuringTest {
    
    public static void main(String[] args) {
        
    String userName, favoriteColor, favoriteFruit;
    int favoriteNumber, productOfFavoriteNumbers;
    
    Scanner inputReaderB = new Scanner(System.in);
    
    System.out.println("Hello there!");
    System.out.print("What's your name? ");
    userName = inputReaderB.nextLine();
    
    System.out.println(" ");
    System.out.print("Hi, " + userName + "! What's your favorite color? ");
    favoriteColor = inputReaderB.nextLine();
    
    System.out.println(" ");
    System.out.println("Huh, " + favoriteColor + "? Mine's Electric Lime.");
    System.out.println("  ");
    System.out.println("I really like limes. They're my favorite fruit,too.");
    System.out.print("What's YOUR favorite fruit, " + userName + "? ");
    favoriteFruit = inputReaderB.nextLine();
    
    System.out.println(" ");
    System.out.println("Really? " + favoriteFruit + "? That's wild!");
    System.out.print("Speaking of favorites, what's your favorite number? ");
    favoriteNumber = inputReaderB.nextInt();
    
    System.out.println(" ");
    System.out.println(favoriteNumber + " is a cool number. Mine's -7.");
    
    productOfFavoriteNumbers = favoriteNumber * -7;
    System.out.println("Did you know that " + favoriteNumber + " * -7 is " + productOfFavoriteNumbers + "? That's a cool number too.");
    
    System.out.println("  ");
    System.out.println("Well, thanks for talking to me, " + userName + "!");
    
     }
}
