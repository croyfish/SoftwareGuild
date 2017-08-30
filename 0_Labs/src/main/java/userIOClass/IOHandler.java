/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userIOClass;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class IOHandler implements UserIO {
    
    private Scanner readInput = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    @Override
    public  double readDouble(String prompt) {
        print(prompt);
        double parsedDouble = readInput.nextDouble();
        readInput.nextLine();
        return parsedDouble;
    }

    
    @Override
    public double readDouble(String prompt, double min, double max) {
        double parsedDouble;
        do {
        print(prompt);
        parsedDouble = readInput.nextDouble();
        readInput.nextLine();
        } while (parsedDouble < min || parsedDouble > max);
        return parsedDouble;
    }

    @Override
    public float readFloat(String prompt) {
        print(prompt);
        float parsedFloat = readInput.nextFloat();
        readInput.nextLine();
        return parsedFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float parsedFloat;
        do {
        print(prompt);
        parsedFloat = readInput.nextFloat();
        readInput.nextLine();
        } while (parsedFloat < min || parsedFloat > max);
        return parsedFloat;
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        int parsedInt = readInput.nextInt();
        readInput.nextLine();
        return parsedInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int parsedInt;
        do {
        print(prompt);
        parsedInt = readInput.nextInt();
        readInput.nextLine();
        } while (parsedInt < min || parsedInt > max);
        return parsedInt;
    }

    @Override
    public long readLong(String prompt) {
        print(prompt);
        long parsedLong = readInput.nextLong();
        readInput.nextLine();
        return parsedLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long parsedLong;
        do {
        print(prompt);
        parsedLong = readInput.nextLong();
        readInput.nextLine();
        } while (parsedLong < min || parsedLong > max);
        return parsedLong;
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        String parsedString = readInput.nextLine();
        return parsedString;
    }    
    
}
