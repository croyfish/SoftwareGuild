/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.labs;

// Import Scanner and Random classes to RockPaperScissors class.
import java.util.Scanner;
import java.util.Random;

/**
 * Finished
 * @author jeffc
 */
public class RockPaperScissors {
    
    public static void main(String[] args) {
      
        // Declare new objects to create random values
        // and read user console input.
        Random randomizer = new Random();
        Scanner readInput = new Scanner(System.in);

        // Declare variables for number of rounds,
        // user's choice in the game, and computer's choice
        // in the game.
        int rounds, userChoice, comChoice;
        
        while (true) {
        
            // Declare and initialize variables to 
            // track ties, user wins, and computer wins.
            int ties = 0, userWins = 0, comWins = 0;
        
            System.out.println("Let's Rock! (or paper... or scissors...)");
        
            // Ask user for number of rounds.
            System.out.print("How many rounds do you want to play? ");
            rounds = readInput.nextInt();
            // Account for Scanner carriage return problem with nextInt;
            readInput.nextLine();
            
            // If number of rounds is invalid, return out of
            // main method and end program.
            if ((rounds <= 1) || (rounds >= 10)) {
                System.out.println("Error: invalid entry.");
                return;
            }

            System.out.println("");
            
            // Play the game until the set number of rounds is reached.
            for (int i = 0; i < rounds; i++) {
            
                System.out.println("Welcome to Round " + (i + 1));
            
                // This loop validates the user's choice
                while (true) {
                    // User chooses Rock, Paper, or Scissors
                    System.out.print("Choose your weapon (1 = Rock, "
                                     + "2 = Paper, 3 = Scissors): ");
                    userChoice = readInput.nextInt();
                    readInput.nextLine();
                    
                    // If choice is valid, break out of validation loop.
                    if ((userChoice >= 1) && (userChoice <= 3)) {
                    break;
                    }
                
                    // If choice is invalid, print error message and retry.
                    System.out.println("Please enter a number from 1 to 3.");
                }
                
                // Computer's choice is determined randomly.
                comChoice = randomizer.nextInt(3) + 1;
            
                // If user chooses Rock, print out result and 
                // increment corresponding variable for computer's
                // choice in each case.
                if (userChoice == 1) {
                    switch (comChoice) {
                        case 1: System.out.println("Computer chooses Rock.");
                            System.out.println("The game is a tie.");
                            ties++; break;
                        case 2: System.out.println("Computer chooses Paper.");
                            System.out.println("COMPUTER WINS!!!!!!");
                            comWins++; break;
                        case 3: System.out.println("Computer chooses Scissors.");
                            System.out.println("You win.");
                            userWins++; break;
                    }
                }
                
                // Do the same if user chooses Paper.
                if (userChoice == 2) {
                    switch (comChoice) {
                        case 1: System.out.println("Computer chooses Rock.");
                            System.out.println("You win.");
                            userWins++; break;
                        case 2: System.out.println("Computer chooses Paper.");
                            System.out.println("The game is a tie.");
                            ties++; break;
                        case 3: System.out.println("Computer chooses Scissors.");
                            System.out.println("COMPUTER WINS!!!!!!");
                            comWins++; break;
                    }
                }
            
                // Do the same if user chooses Scissors.
                if (userChoice == 3) {
                    switch (comChoice) {
                        case 1: System.out.println("Computer chooses Rock.");
                            System.out.println("COMPUTER WINS!!!!!!");
                            comWins++; break;
                        case 2: System.out.println("Computer chooses Paper.");
                            System.out.println("You win.");
                            userWins++; break;
                        case 3: System.out.println("Computer chooses Scissors.");
                            System.out.println("The game is a tie.");
                            ties++; break;
                    }
                }
                
                System.out.println("");
                
            }
        
            // Print out results of match to console.
            System.out.println("The match is over.");
            System.out.println("User wins: " + userWins);
            System.out.println("Ties: " + ties);
            System.out.println("Computer wins: " + comWins);
        
            // Print out winner of match.
            if (userWins > comWins) {
                System.out.println("You win the match.");
            }
        
            if (userWins == comWins) {
                System.out.println("The match is a tie.");
            }
        
            if (userWins < comWins) {
            System.out.println("COMPUTER WINS THE MATCH!!!!!!!!");
            }
            
            System.out.println("");
            
            // Declare a string to track user's intention to play game again.
            String playAgain;
            
            // Validation loop breaks only when input is valid.
            while (true) {
                
                //Store user's response in playAgain string.
                System.out.print("Do you want to play again (y/n)? ");
                playAgain = readInput.nextLine();
                
                if (playAgain.equals("y") || playAgain.equals("n")) {
                break;
                }
                
                // Error message.
                System.out.println("Please enter 'y' or 'n'.");
            }
            
            // If user doesn't want to play again, break out of game loop.
            if (playAgain.equals("n")) {
                break;
            }
            
            System.out.println("");
        }
        
        // Print message after last match.
        System.out.println("Thanks for playing!");
    }
}
