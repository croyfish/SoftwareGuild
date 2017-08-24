/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;
/**
 *Write a while loop that asks the 
 * user for a number and counts down 
 * from it, printing out each number 
 * until it reaches zero, and then 
 * stops. (Stop at zero because the 
 * numbers after, they just get too 
 * NEGATIVE to deal with!)

BONUS: Print out 10 numbers per line, 
* and then start a new line ...
 * @author jeffc
 */
public class StayPositive {
    
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
    
        int countDownFrom, lineCount = 0;
        
        System.out.print("What number should I count down from? ");
        countDownFrom = readInput.nextInt();
        readInput.nextLine();
        System.out.println("");
        System.out.println("Here goes!");
        System.out.println("");
        
        while (countDownFrom > -1) {
            System.out.print(countDownFrom + " ");
            if (countDownFrom % 10 == 0) {
                System.out.print("\n");
            }
            countDownFrom--;
        }
        System.out.print("");
        
        
    
        }
    
    
}
