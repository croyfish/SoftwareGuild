/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userIOClass;

/**
 *
 * @author jeffc
 */
public class App {
    public static void main(String[] args) {
        
        UserIO myIO = new RealBadUserIO();
        
        myIO.print("Hello World.");
        
        int enteredInt = myIO.readInt("Please enter an int");
        
        myIO.print("You entered: " + enteredInt);
        
        
    }
}