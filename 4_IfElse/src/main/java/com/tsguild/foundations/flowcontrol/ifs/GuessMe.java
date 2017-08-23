/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author jeffc
 */
public class GuessMe {
    public static void main(String[] args) {
        
        int pickedInteger, guess;
        
        pickedInteger = (int) ((100 * Math.random()) + 1);
        
        Scanner readInput = new Scanner(System.in);
        
        System.out.println("I've chosen a number. Betcha can't guess it!");
        System.out.print("Your guess: ");
        guess = readInput.nextInt();
        
        if (guess == pickedInteger) {
            System.out.println("Wow, nice Guess! That was it!");
        } else if (guess < pickedInteger) {
            System.out.println("Ha, nice try - too low! I chose " + pickedInteger);
        } else {
            System.out.println("Too bad, way too high. I chose " + pickedInteger);
        }
        
        
                
    }
}
