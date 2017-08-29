/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoredFactorizor;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class Factorizor {
    
    public void findFactors() {
        
        Scanner readInput = new Scanner(System.in);
        
        int numberToFactor, numberOfFactors = 0, sumOfFactors = 0;
        
        do {
        System.out.print("What number would you like to factor? ");
        numberToFactor = readInput.nextInt();
        readInput.nextLine();
        if (numberToFactor < 1) {
            System.out.println("Invalid input! Please choose a positive integer.");
        }
        } while (numberToFactor < 1);
        
        System.out.println("The factors of " + numberToFactor + " are:");
        
        for (int i = 1; i <= numberToFactor; i++) {
            if (numberToFactor % i == 0) {
                numberOfFactors++;
                sumOfFactors += i;
                System.out.println(i);
            }
        }
        
        if (numberToFactor == sumOfFactors - numberToFactor) {
            System.out.println(numberToFactor + " is a perfect number.");
        } else {
            System.out.println(numberToFactor + " is not a perfect number.");
        }
        
        if (numberOfFactors == 2) {
            System.out.println(numberToFactor + " is a prime number.");
        } else {
            System.out.println(numberToFactor + " is not a prime number.");
        }
        
        
    }
}
