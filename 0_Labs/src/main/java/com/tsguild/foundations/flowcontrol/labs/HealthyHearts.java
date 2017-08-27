
package com.tsguild.foundations.flowcontrol.labs;

// imports Scanner to HealthyHearts class
import java.util.Scanner;
/**
 * Finished
 * @author jeffc
 */
public class HealthyHearts {
    
    public static void main(String[] args) {
        
        // Creates a new instance of Scanner
        Scanner inputReader = new Scanner(System.in);
        
        // Declare variables for user's age, maximum heart rate
        int userAge, maxHeartRate; 
        // target lower and target upper heart rates (as ints)
        int targetHRLowerInt, targetHRUpperInt;
        // and target lower and upper HRs (as double precisions)
        double targetHRLowerD, targetHRUpperD;
        
        // Loop validates input for age (must be a non-negative integer)
        while (true) {
        
            // Asks for user's age and reads in integer.
            System.out.print("What is your age? ");
            userAge = inputReader.nextInt();
            inputReader.nextLine();
            
            // If user's age is a valid age, breaks out of validation loop.
            if (userAge > -1) {
                break;
            }
            
            // Prompt's user to re-enter invalid input.
            System.out.println("Please enter a non-negative integer.");
        }
        
        // Calculate maximum HR and lower and upper target HRs (as doubles)
        maxHeartRate = 220 - userAge;
        targetHRLowerD = .5 * maxHeartRate;
        targetHRUpperD = .85 * maxHeartRate;
        
        // Cast double lower/upper Hrs as integers
        targetHRLowerInt = (int)targetHRLowerD;
        targetHRUpperInt = (int)targetHRUpperD;
        
        // Account for rounding errors caused by casting double
        // as int and dropping decimal places
        if (targetHRLowerD % (int)targetHRLowerD >= .5) {
            targetHRLowerInt++;
        }
        
        if (targetHRLowerD % (int)targetHRUpperD >= .5) {
            targetHRUpperInt++;
        }
        
        // Prints max HR and target HR zone to console.
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR zone is " + targetHRLowerInt + " - " + targetHRUpperInt + " beats per minute.");
    }
}
