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
public class CoinFlipper {
    public static void main(String[] args) {
        
        Random randomizer = new Random();
        
        boolean coin = randomizer.nextBoolean();
        
        if (coin == true) {
            System.out.println("You got HEADS!");
        } else {
            System.out.println("You got TAILS!");
        }
    }
}

