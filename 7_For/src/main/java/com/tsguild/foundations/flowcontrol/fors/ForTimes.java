/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.fors;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class ForTimes {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        
        int numberToMultiply;
        
        System.out.print("Which times table shall I recite? ");
        numberToMultiply = readInput.nextInt();
        readInput.nextLine();
        
        for (int i = 1; i < 16; i++) {
            System.out.println(i + " * " + numberToMultiply + " is: " + (i * numberToMultiply));
        }
    }
}
