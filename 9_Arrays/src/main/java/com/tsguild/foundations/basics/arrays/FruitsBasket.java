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
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", 
            "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        
        int apples = 0, oranges = 0, fruits = 0;
        
        for (String fruitType : fruit) {
            if (fruitType.equals("Apple")) {
                apples++;
            }
            if (fruitType.equals("Orange")) {
                oranges++;
            }
            fruits++;
        }
        
        String[] appleBasket = new String[apples];
        String[] orangeBasket = new String[oranges];
        
        int numApples = 0, numOranges = 0;
        
        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i].equals("Apple")) {
                appleBasket[numApples] = "Apple";
                numApples++;
            }
            if (fruit[i].equals("Orange")) {
                orangeBasket[numOranges] = "Orange";
                numOranges++;
            }
            fruit[i] = null;
        }
        
        System.out.println("Total# of fruit in Basket: " + fruits);
        System.out.println("Number of Apples: " + appleBasket.length);
        System.out.println("Number of Oranges: " + orangeBasket.length);
        
        

        
    }
}
