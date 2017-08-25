/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.labs;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
/**
 *
 * @author jeffc
 */
public class InterestCalculator {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        
        float annualInterestRate, principal;
        int years;
        
        System.out.print("What is the annual interest rate (in %)? ");
        annualInterestRate = Float.parseFloat(readInput.nextLine());
        System.out.print("What is the principal amount? $");
        principal = Float.parseFloat(readInput.nextLine());
        System.out.print("How many years will the money remain in the fund? ");
        years = readInput.nextInt();
        readInput.nextLine();
        System.out.println("");
        
        for (int i = 0; i < years; i++) {
            System.out.println("Year " + (i + 1));
            System.out.println("Principal at beginning of year: $" + twoPlaces.format(principal));
            
            float newPrincipal = calculateQuarterlyInterest(principal, annualInterestRate);
            principal = newPrincipal;
            System.out.println("");
        }

    }
    
    public static float calculateQuarterlyInterest(float principal, float annualInterestRate) {
            
            int quarter = 0;
            float yearlyInterest;
            float newPrincipal = principal;
            DecimalFormat twoPlaces = new DecimalFormat("0.00");
            
            do {
                quarter++;
                newPrincipal = (newPrincipal * (1 + ((annualInterestRate / 4)/ 100)));           
            } while (quarter < 4);
            
            yearlyInterest = newPrincipal - principal;
            System.out.println("Total amount of interest earned this year: $"
                    + twoPlaces.format(yearlyInterest));
            
            System.out.println("Principal at the end of the year: $" 
                    + twoPlaces.format(newPrincipal));
            return newPrincipal;
            
    }
    
    
}
