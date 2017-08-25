/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class DoOrDoNot {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        
        boolean doIt;
        
        if (readInput.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }
        
        boolean iDidIt = false;
        
        /*
        do {
            iDidIt = true;
            break;
        } while (doIt);
        */
        
        while (doIt) {
            iDidIt = true;
            break;
        }
        
        // If only a while loop, "I did it!" prints out for y.

        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totall did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }
    }
}
