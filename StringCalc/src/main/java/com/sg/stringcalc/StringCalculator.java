/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.stringcalc;

/**
 *
 * @author jeffc
 */
public class StringCalculator {

    public int sum(String input) {
        
        String delimiter = ",";
        
        
        
        String[] results = input.split("\\D*");
        // "1\n2" , "3"
        int sum  =0;
         for (String currentString2 : results) { 
                if (!currentString2.equals("")) {
                sum += Integer.parseInt(currentString2);
                }
            }
        
        
        return sum;
        
        
        
    }
    
}
