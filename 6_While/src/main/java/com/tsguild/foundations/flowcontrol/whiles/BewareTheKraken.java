/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jeffc
 */
public class BewareTheKraken {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        Random randomizer = new Random();
        
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");
        
        int depthDivedInFt  = 0, fishType;
        String diveMore;
        
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        // If the condition here is changed to "true", the program will work
        // the same way, because we're breaking out of the loop anyway when we
        // dive to the kraken.
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");
            
            fishType = randomizer.nextInt(2);
            
            switch (fishType) {
                case 0: System.out.println("You saw a haddock.");
                break;
                case 1: System.out.println("You saw a salmon.");
                break;
                case 2: System.out.println("You saw a sea bass.");
                break;
            }
            
            
            System.out.print("Do you want to stop? (y/n) ");
            diveMore = readInput.nextLine();
            
            if (diveMore.equals("y")) {
                break;
            }
            
            
            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                
                break;
            }
            
            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
