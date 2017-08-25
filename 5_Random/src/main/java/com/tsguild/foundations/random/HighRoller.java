/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.random;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jeffc
 */
public class HighRoller {
    public static void main(String[] args) {
        
        Random diceRoller = new Random();
        Scanner readInput = new Scanner(System.in);
        
        int sidesOfDice;
        System.out.print("How many sides does the dice have? ");
        sidesOfDice = readInput.nextInt();
        readInput.nextLine();
        
        int rollResult = diceRoller.nextInt(sidesOfDice) + 1;
        
        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        
        System.out.println("I rolled a " + rollResult);
        
        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        }
        
        if (rollResult == sidesOfDice) {
            System.out.println("You rolled a critical! Nice job!");
        }
    }
}
