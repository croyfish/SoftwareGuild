package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeffc
 */
public class TheCount {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        
        int startAt, stopAt, countBy, miniCounter = 0;
        
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        
        System.out.print("Start at : ");
        startAt = readInput.nextInt();
        readInput.nextLine();
        
        System.out.print("Stop at : ");
        stopAt = readInput.nextInt();
        readInput.nextLine();
        
        System.out.print("Count by : ");
        countBy = readInput.nextInt();
        readInput.nextLine();
        
        System.out.println("");

        for (int i = startAt; i <= stopAt; i += countBy) {
        System.out.print(i + " ");
        miniCounter++;
        if (miniCounter % 3 == 0) {
            System.out.println("- Ah ah ah!");
        }
        
    }
}
}

