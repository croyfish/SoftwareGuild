/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles;

/**
 *
 * @author jeffc
 */
public class LovesMe {
    
    public static void main(String[] args) {
            
        int petals = 34;

            
        while (petals > 0) {
            petals--;
            if (petals % 2 != 0) {
                System.out.println("It loves me NOT!");
            } else {
                System.out.println("It LOVES me!");
            }
        }
        System.out.println("I knew it! It LOVES ME!");
    }
}
