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
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 78, 89, 100};
        
        int[] wholeNumbers = new int[24];
        
        int firstHalfIndex = 0, secondHalfIndex = 0;
        
        for (int i = 0; i < 23; i++) {
            if (firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
                wholeNumbers[i] = firstHalf[firstHalfIndex++];
            } else {wholeNumbers[i] = secondHalf[secondHalfIndex++];
            }
        }
        wholeNumbers[23] = 100;
        
        System.out.println("Here ya go - all nice and ordered: ");
        
        for (int num : wholeNumbers) {
            System.out.print(num + " ");
        }

    }
}
