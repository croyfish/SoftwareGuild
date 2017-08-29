/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoredInterestCalculator;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
/**
 *
 * @author jeffc
 */
public class InterestCalculator {
    
    public void calculateInterest() {
        
        Scanner readInput = new Scanner(System.in);
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        
        float annualInterestRate, principal;
        int years, freqIntRate, intChoice; 
        
        System.out.print("What is the annual interest rate (in %)? ");
        annualInterestRate = Float.parseFloat(readInput.nextLine());
        System.out.println("How often is the interest compounded?\n1) daily\n2) monthly \n3) quarterly");
        intChoice = readInput.nextInt();
        readInput.nextLine();
        
        switch (intChoice) {
            case 1: freqIntRate = 365;
            break;
            case 2: freqIntRate = 12;
            break;
            case 3: freqIntRate = 4;
            break;
            default: freqIntRate = 1;
                System.out.println("Your choice is invalid. Yearly interest will be calculated.");
        }
 
        System.out.print("What is the principal amount? $");
        principal = Float.parseFloat(readInput.nextLine());
        System.out.print("How many years will the money remain in the fund? ");
        years = readInput.nextInt();
        readInput.nextLine();
        System.out.println("");
        
        for (int i = 0; i < years; i++) {
            System.out.println("Year " + (i + 1));
            System.out.println("Principal at beginning of year: $" + twoPlaces.format(principal));
            float newPrincipal = calculateCompoundInterest(principal, annualInterestRate, freqIntRate);
            principal = newPrincipal;
            System.out.println("");
        }

    }
    
    public static float calculateCompoundInterest(float principal, float annualInterestRate, int freqIntRate) {
            
            int period = 0;
            float yearlyInterest;
            float newPrincipal = principal;
            DecimalFormat twoPlaces = new DecimalFormat("0.00");
            
            do {
                period++;
                newPrincipal = (newPrincipal * (1 + ((annualInterestRate / freqIntRate)/ 100)));           
            } while (period < freqIntRate);
            
            yearlyInterest = newPrincipal - principal;
            System.out.println("Total amount of interest earned this year: $"
                    + twoPlaces.format(yearlyInterest));
            
            System.out.println("Principal at the end of the year: $" 
                    + twoPlaces.format(newPrincipal));
            return newPrincipal;
            
    }
    
    
}
