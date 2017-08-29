/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.arrays;

/**
 *
 * @author jeffc
 */
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", 
            "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", 
            "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  
            "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", 
            "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", 
            "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        String[] fruitSalad = new String[12];
        int saladIndex = 0;
        
        for (String fruitPick : fruit) {
            if (fruitPick.contains("berry") || fruitPick.contains("Berry")) {
                fruitSalad[saladIndex] = fruitPick;
                saladIndex++;
            }
        }
    
        
    }
}

