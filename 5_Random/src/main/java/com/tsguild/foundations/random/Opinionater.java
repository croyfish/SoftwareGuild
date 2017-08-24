/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.random;

import java.util.Random;
/**
 *
 * @author jeffc
 */
public class Opinionater {
    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("I can't decide what animal I like the best.");
        System.out.println("I know! Random can decide that FOR ME!");
        
        // The bug was that random.nextInt(5) will never produce the value 5
        // because the decimal part of an int gets truncated.
        // Therefore, we should use nextInt(6) to generate integers
        // from 0 to 5 (inclusive).
        int x = randomizer.nextInt(6);
                
        
        System.out.println("The number we chose was: " + x);
        
        if (x == 0) {
            System.out.println("LLamsa are the best!");
        } else if (x == 1) {
            System.out.println("Dodos are the best!");
        } else if (x == 2) {
            System.out.println("Woolly Mammoths are DEFINITELY the best!");
        } else if (x == 3) {
            System.out.println("Sharks are the greatest, they have their own week!");
        } else if (x == 4) {
            System.out.println("Cockatoos are just so awesomme!");
        } else if (x == 5) {
            System.out.println("Have you ever met a Mole-Rat? They're GREAT!");
        }
        
        System.out.println("Thanks Random, maybe YOU're the best!");
    }
}
