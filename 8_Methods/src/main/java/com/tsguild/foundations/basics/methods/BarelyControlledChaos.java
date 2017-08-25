/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.methods;

import java.util.Random;

/**
 *
 * @author jeffc
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {
        

        
        String color = returnRandomColor(); // call color method here
        String animal = returnRandomAnimal(); // call animal method here
        String colorAgain = returnRandomColor(); // call color method again here
        int weight = returnRandomInRange(5, 200); // call number method,
            // with a range between 5 - 200
        int distance = returnRandomInRange(10, 20); // call number method,
            // with a range between 10 - 20
        int number = returnRandomInRange(10000, 20000); // call number method,
            // with a range between 10000 - 20000
        int time = returnRandomInRange(2, 6); // call number method,
            // with a range between 2 - 6
            
        System.out.println("Once, when I was very small...");
        
        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");
        
        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");
        
        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }
    
    public static String returnRandomColor() {
        Random randomizer = new Random();
        int color = randomizer.nextInt(5) + 1;
        String colorName = "no color";
        switch (color) {
            case 1: colorName = "red";
            break;
            case 2: colorName = "blue";
            break;
            case 3: colorName = "green";
            break;
            case 4: colorName = "yellow";
            break;
            case 5: colorName = "brown";
            break;
        }
        return colorName;
    }
    
        public static String returnRandomAnimal() {
        Random randomizer = new Random();
        int animal = randomizer.nextInt(5) + 1;
        String animalName = "no animal";
        switch (animal) {
            case 1: animalName = "chinchilla";
            break;
            case 2: animalName = "lemur";
            break;
            case 3: animalName = "ferret";
            break;
            case 4: animalName = "stoat";
            break;
            case 5: animalName = "weasel";
            break;
        }
            return animalName;
    }
        
        public static int returnRandomInRange(int min, int max) {
            Random randomizer = new Random();
            return randomizer.nextInt(max - min) + min;
        }
}

    

