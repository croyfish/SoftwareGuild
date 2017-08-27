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
public class StillPositive {
    public static void main(String[] args) {
        
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868,
            -776, 227, -744, 422, -10, 259, -500, 278, -219, 799, -311};
        
        System.out.println("Gotta stay positive ...!");
        
        for (int num : numbers) {
            if (num > 0) {
                System.out.print(num + " ");
            }
        }
    }
}
