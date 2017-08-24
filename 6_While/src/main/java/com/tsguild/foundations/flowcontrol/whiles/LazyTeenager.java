/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Random;

/**
 *
 * @author jeffc
 * Write a program that simulates a lazy teenager who won't clean their 
 * room until their parent tells them repeatedly to do it.

You should write this in a do/while loop, which continues to 
* execute until the room is clean.

Every time the loop executes, the parent should tell the teenager 
* to clean their room. Each time the teenager is told to clean their room, it 
* increases the chance the teenager will clean the room by 5%. However, by 
* the 15th time, they're going to get grounded and have their xbox confiscated. 
* (Note: Use a break, not a compound condition to stop the loop in that case.)

So the first time they're told, there is only a 5% chance they'll clean it.
The second time, there's a 10% chance. Use Random to calculate this “chance” 
* check.
 */
public class LazyTeenager {
    public static void main(String[] args) {
        
        int probabilityToClean = 5;
        int yellingCounter = 1;
        Random randGenerator = new Random();
        
        do {
            System.out.println("CLEAN YOUR ROOM!!! (x" + yellingCounter + ")");
            probabilityToClean += 5;
            yellingCounter++;
            if (yellingCounter == 16) {
                break;
            } 
        } while (probabilityToClean < randGenerator.nextInt(101));
        
        if (yellingCounter == 16) {
            System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
        } else {
        System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
        }
    }
}
