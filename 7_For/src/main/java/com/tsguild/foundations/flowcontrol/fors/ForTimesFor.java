/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class ForTimesFor {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        
        int numberToMultiply, guess, numberCorrect = 0;
        
        System.out.print("Which times table shall I recite? ");
        numberToMultiply = readInput.nextInt();
        readInput.nextLine();
        
        for (int i = 1; i < 16; i++) {
            System.out.print(i + " * " + numberToMultiply + " is: " );
                guess = readInput.nextInt();
                readInput.nextLine();
                
                if (guess == i * numberToMultiply) {
                    System.out.println("Correct!");
                    numberCorrect++;
                } else {
                    System.out.println("Sorry no, the answer is: " + (i * numberToMultiply));
                }
                
        }
                System.out.println("You got " + numberCorrect + " correct.");
                if (numberCorrect < 8) {
                    System.out.println("You should study more.");
                }
                if (numberCorrect > 13) {
                    System.out.println("Contratulations! You're a cheese wiz!");
                }
                
        
    }
}
