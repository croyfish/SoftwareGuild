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
public class ArraysPractice {
    public static void main(String[] args) {
        int[] myArray = new int[10];
        
        
        myArray[0] = 5;
        myArray[1] = 6;
        myArray[2] = 62;
        myArray[3] = 66;
        myArray[4] = 72;
        myArray[5] = 36;
        myArray[6] = 76;
        myArray[7] = 16;
        myArray[8] = 86;
        myArray[9] = 46;
        // myArray[10] = 35;
        
        int aValue = myArray [7];
        System.out.println(aValue);
        
        int sum = 0;
        /*
        for (int i = 0; i < myArray.length; i++) {
            int currentValue = myArray[i];
            System.out.println(currentValue);
            sum += currentValue;
        }
        */
        for (int currentValue : myArray) {
            System.out.println(currentValue);
            sum += currentValue;
        }
        
        System.out.println(sum);
    }
}
