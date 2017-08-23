/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.variables;

/**
 *
 * @author jeffc
 */
public class AllAboutMe {
    public static void main(String[] args) {
        String myName, favoriteFood;
        int numberOfPets, ageLearnedToWhistle;
        boolean eatenGnocchi;
        
        myName = "Jeff Croyle";
        favoriteFood = "sushi";
        numberOfPets = 3;
        ageLearnedToWhistle = 11;
        eatenGnocchi = true;
        
        System.out.println("I am " + myName + ".");
        System.out.println("I have " + numberOfPets + " pets.");
        System.out.println("My favorite food is " + favoriteFood + ".");
        System.out.println("It is " + eatenGnocchi + " that I have eaten gnocchi.");
        System.out.println("And when I was " + ageLearnedToWhistle + " years old, I learned to whistle.");
        
        
    }
}
