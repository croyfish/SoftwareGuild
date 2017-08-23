/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author jeffc
 */
public class MiniMadLibs {
    public static void main(String[] args) {
        
        Scanner inputReaderE = new Scanner(System.in);
        
        String noun1, adj1, noun2, number, adj2; 
        String plNoun1, plNoun2, plNoun3, verbPres, verbPast;
        
        System.out.println("Let's play MAD LIBS!");
        System.out.println(" ");
        System.out.print("I need a noun: ");
        noun1 = inputReaderE.nextLine();
        System.out.print("Now an adj: ");
        adj1 = inputReaderE.nextLine();
        System.out.print("Another noun: ");
        noun2 = inputReaderE.nextLine();
        System.out.print("And a number: ");
        number = inputReaderE.nextLine();
        System.out.print("Another adj: ");
        adj2 = inputReaderE.nextLine();
        System.out.print("A plural noun: ");
        plNoun1 = inputReaderE.nextLine();
        System.out.print("Another one: ");
        plNoun2 = inputReaderE.nextLine();
        System.out.print("One more: ");
        plNoun3 = inputReaderE.nextLine();
        System.out.print("A verb (present tense): ");
        verbPres = inputReaderE.nextLine();
        System.out.print("Same verb (past tense): ");
        verbPast = inputReaderE.nextLine();
        
        //        String noun1, adj1, noun2, number, adj2; 
        //      String plNoun1, plNoun2, plNoun3, verbPres, verbPast;
        
        System.out.println(" ");
        System.out.println(noun1 + ": the " + adj1 + " frontier. These are the"
        + " voyages of the starship " + noun2 + ". Its " + number + "-year"
        + " mission: to explore");
        System.out.println("strange " + adj2 + " " + plNoun1 + ", to seek out "
        + adj2 + " " + plNoun2 + " and " + adj2 + " " + plNoun3 + ", to boldly "
        + verbPres + " where no one has " + verbPast + " before.");

        
       
        
        /*

A verb (present tense): sneeze
Same verb (past tense): sneezed

*** NOW LETS GET MAD (libs) ***
Chocolate: the spooky frontier. These are the voyages of the 
starship Dodo. Its 10101-year mission: to explore strange red kittens, 
to seek out red balls and red lettuce, to boldly sneeze where no one 
has sneezed before. */
    }
}
