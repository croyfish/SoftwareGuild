/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.arrays;

import java.util.Random;
/**
 *
 * @author jeffc
 */
public class HiddenNuts {
    
    public static void main(String[] args) {
        
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        
        int index = 0;
        for (String spot : hidingSpots) {
            if (spot != null && spot.equals("Nut")) {
                System.out.println("... at array index " + index + ".");
                return;
            }
            index++;
        }
    }
}
