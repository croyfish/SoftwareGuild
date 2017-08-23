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
 */
public class BiggerBetterAdder {
    public static void main(String[] args) {
        
        int variable1, variable2, variable3, variableSum;
        
        Scanner inputReader = new Scanner(System.in);
        
        
        //variable1 = 12;
        variable2 = -16;
        variable3 = 127;
       
        
        System.out.print("Type a value for variable 1: ");
        variable1 = inputReader.nextInt();
        
        System.out.print("Type a value for variable 2: ");
        variable2 = inputReader.nextInt();
        
        System.out.print("Type a value for variable 3: ");
        variable3 = inputReader.nextInt();
        
        System.out.println("Variable1 is " + variable1);
        System.out.println("Variable2 is " + variable2);
        System.out.println("Variable3 is " + variable3);
        
        variableSum = variable1 + variable2 + variable3;
        
        System.out.println("The sum is " + variableSum);
        System.out.println("The sum is " + variableSum);
        
        
    }
}
