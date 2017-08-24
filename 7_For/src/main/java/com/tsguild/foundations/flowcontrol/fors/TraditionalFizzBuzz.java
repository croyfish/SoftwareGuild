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
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        
        int fizzBuzzCount = 0, fizzBuzzLimit = 0;
        Scanner readInput = new Scanner(System.in);
        
        while (fizzBuzzLimit < 1) {
        System.out.print("How much units fizzing and buzzing do you need in your life? " );
        fizzBuzzLimit = readInput.nextInt();
        readInput.nextLine();
        }
        
        System.out.println(0);
        
        for (int i = 1; fizzBuzzCount < fizzBuzzLimit; i++) {
            
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz buzz");
                fizzBuzzCount++;
            } else if (i % 3 == 0) {
                System.out.println("fizz");
                fizzBuzzCount++;
            } else if (i % 5 == 0) {
                System.out.println("buzz");
                fizzBuzzCount++;
            } else {
                System.out.println(i);
            }
        }
        
        System.out.println("TRADITION!!!!!");
        
    }
}
