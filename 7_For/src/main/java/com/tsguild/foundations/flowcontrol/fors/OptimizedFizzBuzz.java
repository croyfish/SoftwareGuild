package com.tsguild.foundations.flowcontrol.fors;
import java.util.Scanner;
public class OptimizedFizzBuzz {
    public static void main(String[] args) {
        
        int fizzBuzzCount = 0, fizzBuzzLimit = 0;
        Scanner readInput = new Scanner(System.in);
        
        while (fizzBuzzLimit < 1) {
        System.out.print("How much units fizzing and buzzing do you need in your life? " );
        fizzBuzzLimit = readInput.nextInt();
        readInput.nextLine();
        }
        
        for (int i = 1; fizzBuzzCount < fizzBuzzLimit; i++) {
        //System.out.println((i % 3 == 0) ? "Fizz " : "" + (i % 5 == 0) ? "Buzz " : "" + ((i % 3 != 0) && (i % 5 != 0) ? i : "");
            System.out.println((i % 3 == 0 ? "Fizz" : "") + (i % 5 == 0 ? "Buzz " : "") + (i % 3 != 0 && i % 5 != 0 ? i : ""));
            fizzBuzzCount++;
        }
        /*
        for (int i = 1; fizzBuzzCount < fizzBuzzLimit; i++) {
            
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz buzz");
                fizzBuzzCount++;
            } else if (i % 3 == 0) {
                System.out.println("fizz");
                fizzBuzzCount++;
            } else if (i % 5 == 0) {
                System.out.println("buzz");
                fizzBuzzCount++;
            } else {
                System.out.println(i);
            }
        } */
        
        System.out.println("TRADITION!!!!!");
        
    }
}
