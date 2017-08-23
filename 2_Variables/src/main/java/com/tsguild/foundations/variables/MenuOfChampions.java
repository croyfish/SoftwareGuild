/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.variables;

/**
 *
 * @author jeffc
 */
public class MenuOfChampions {
    public static void main(String[] args) {
        
        String restaurantName, food1, food2, food3;
        float food1Price, food2Price, food3Price;
        
        restaurantName = "Mobile Munchies";
        food1 = "Quesadillas";
        food2 = "Enchiladas";
        food3 = "Quesaladas";
        food1Price = (float) 4.25;
        food2Price = (float) 3.59;
        food3Price = (float) 9.75;
        
        System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.");
        System.out.println("  ");
        System.out.println("            Welcome to " + restaurantName + "!");
        System.out.println("  ");
        System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.");
        System.out.println("  ");
        System.out.println("      " + food1 + "    $" + food1Price);
        System.out.println("      " + food2 + "     $" + food2Price);
        System.out.println("      " + food3 + "     $" + food3Price);
        
    }
 
}
