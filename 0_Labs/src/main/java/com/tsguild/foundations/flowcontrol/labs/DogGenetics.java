/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.labs;

// Import Random and Scanner classes to DogGenetics class
import java.util.Random;
import java.util.Scanner;
/**
 * Finished
 * @author jeffc
 */
public class DogGenetics {
    
    public static void main(String[] args) {
        
        // Create new instances of Random and Scanner
        Random randomizer = new Random();
        Scanner readInput = new Scanner(System.in);
        
        // Declare String for dog's name
        String dogsName;
        
        // Declare float variables for percentages of
        // five breeds of dogs as well as their sum.
        float breed1Percent, breed2Percent, breed3Percent; 
        float breed4Percent, breed5Percent, breedPercentSum;
        
        // Ask user for dog's name and store to dogsName variable.
        System.out.print("What is your dog's name? ");
        dogsName = readInput.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on "
                + dogsName + "'s prestigious background right here.");
        System.out.println("");
        System.out.println(dogsName + " is:");
        System.out.println("");
        
        // Calculate random percentages for each of five dog breeds.
        breed1Percent = randomizer.nextInt(100) + 1;
        breed2Percent = randomizer.nextInt(100) + 1;
        breed3Percent = randomizer.nextInt(100) + 1;
        breed4Percent = randomizer.nextInt(100) + 1;
        breed5Percent = randomizer.nextInt(100) + 1;
        
        // Sum the percentages.
        breedPercentSum = breed1Percent + breed2Percent + breed3Percent
                + breed4Percent + breed5Percent;
        
        // Scale each percentage so that their sum is 100
        // and cut off decimal places.
        breed1Percent = (int)((breed1Percent * 100)/ breedPercentSum);
        breed2Percent = (int)((breed2Percent * 100)/ breedPercentSum);
        breed3Percent = (int)((breed3Percent * 100)/ breedPercentSum);
        breed4Percent = (int)((breed4Percent * 100)/ breedPercentSum);
        
        // The fifth breed percentage is forced to an number that
        // will ensure the sum of the five percentages is 100
        // to eliminate rounding errors.
        breed5Percent = 100 - (breed1Percent + breed2Percent + 
                breed3Percent + breed4Percent);
        
        // Print out results of fake dog DNA test.
        // Percentages are once again cast as integers.
        System.out.println((int)breed1Percent + "% Border Collie");
        System.out.println((int)breed2Percent + "% Australian Shepherd");
        System.out.println((int)breed3Percent + "% Rhodesian Ridgeback");
        System.out.println((int)breed4Percent + "% Cocker Spaniel");
        System.out.println((int)breed5Percent + "% Mastiff");
        System.out.println("");
        System.out.println("Wow, that's QUITE the dog!");
    }
}
