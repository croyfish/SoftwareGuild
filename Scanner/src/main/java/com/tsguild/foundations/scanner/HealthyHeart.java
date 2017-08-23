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
public class HealthyHeart {
    public static void main(String[] args) {
        
        Scanner inputReaderE = new Scanner(System.in);
        
        int userAge, maxHeartRate, targetHRLower, targetHRUpper;
        
        System.out.print("What is your age? ");
        userAge = inputReaderE.nextInt();
        inputReaderE.nextLine();
        
        maxHeartRate = 220 - userAge;
        targetHRLower = (int) (.5 * maxHeartRate);
        targetHRUpper = (int) (.85 * maxHeartRate);
        
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR zone is " + targetHRLower + " - " + targetHRUpper + " beats per minute.");
        /*

Their maximum heart rate should be 220 - their age.
The target heart rate zone is the 50 - 85% of the maximum.
What You Should See

--- exec-maven-plugin:1.2.1:exec (default-cli) @ Unit1 ---
What is your age? 50
Your maximum heart rate should be 170 beats per minute
Your target HR Zone is 85 - 145 beats per minute
*/
        
        
    }
}
