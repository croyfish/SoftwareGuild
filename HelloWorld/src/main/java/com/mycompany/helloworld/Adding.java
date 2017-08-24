/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloworld;

/**
 *
 * @author jeffc
 */
public class Adding {
    
    public static void main(String[] args) {
        int myResult = add1And1 ();
        int result = add(1, 1);
        
        System.out.println(result);
    }
    
    public static int add1And1 () {
        return 1 + 1;
    }
    
    public static int add1And2() {
        return 1 + 2;
    }
    
    public static int add1And3() {
        return 1 + 3;
    }
    
    public static int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
