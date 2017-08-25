/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.random;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jeffc
 */
public class GuessMeMore {
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        
        int pickedInteger, guess;
        
        pickedInteger = randomizer.nextInt(200) - 99;
        
        Scanner readInput = new Scanner(System.in);
        
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!");
        
        do {
        System.out.print("Your guess: ");
        guess = readInput.nextInt();
        
        if (guess == pickedInteger) {
            System.out.println("Wow, nice Guess! That was it!");
        } else if (guess < pickedInteger) {
            System.out.println("Ha, nice try - too low! Try again!");
        } else {
            System.out.println("Too bad, way too high. Try again!");
        }
        
        } while (guess != pickedInteger);
                
    }
}
