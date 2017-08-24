/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class KnockKnock {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();
        
        // If .equals() is changed to ==, the compiler throws an error.
        // If the incorrect capitalization is used in the answer, the result
        // will be false. To fix this, we could write all permutations of
        // capitalization connected with OR operators inside the condition.
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back");
            System.out.println(".... from the Future."); // Sorry, had to!
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}