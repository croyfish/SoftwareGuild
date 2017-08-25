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
 */
public class MaybeItLovesMe {
    
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        int petals = randomizer.nextInt(76) + 13;
        boolean loves = false;
        
        System.out.println("Well here goes nothing... ");
            
        while (petals > 0) {
            petals--;
            loves = !loves;
            if (loves == true) {
            System.out.println("It LOVES me!");
            } else {
            System.out.println("It loves me NOT!");
            }
        }
        
        if (loves == true) {
            System.out.println("Oh, wow! It really LOVES me!");
        } else {
            System.out.println("Awwww, bummer.");
        }
    }
}
