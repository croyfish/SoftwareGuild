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
public class TriviaNight {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
    
        int score = 0, guess;
    
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        
        System.out.println();
        System.out.println("What is the tallest mountain in the world?");
        System.out.println("1) Mount Kilamanjaro         2) Mount Fuji");
        System.out.println("3) Mount Everest             4) Mount Vernon");
        System.out.println();
        System.out.print("YOUR ANSWER: ");
        guess = readInput.nextInt();
        readInput.nextLine();
        
        if (guess == 3) {
            score++;
        }
        
        System.out.println();
        System.out.println("What is the smallest prime number?");
        System.out.println("1) one                       2) two");
        System.out.println("3) three                     4) four");
        System.out.println();
        System.out.print("YOUR ANSWER: ");
        guess = readInput.nextInt();
        readInput.nextLine();
        
        if (guess == 2) {
            score++;
        }
        
        System.out.println();
        System.out.println("What color do yellow and blue make?");
        System.out.println("1) red                       2) pink");
        System.out.println("3) orange                    4) green");
        System.out.println();
        System.out.print("YOUR ANSWER: ");
        guess = readInput.nextInt();
        readInput.nextLine();
        
        if (guess == 4) {
            score++;
        }
        
        System.out.println();
        System.out.print("You got " + score + " correct. ");
        if (score == 0) {
            System.out.println("That's terrible.");
        }
        if (score == 3) {
            System.out.println("Nice job!");
        }
    }
    
    
}
