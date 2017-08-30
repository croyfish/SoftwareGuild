/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleCalculator;

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
        double parsedDouble = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextDouble()) {
                inputIsValid = true;
            } else {
                readInput.nextLine();
                continue;
            }
            
            parsedDouble = readInput.nextDouble();
            readInput.nextLine();
        }
        return parsedDouble; 
    }

    
    @Override
    public double readDouble(String prompt, double min, double max) {
        
        double parsedDouble = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextDouble()) {
                inputIsValid = true;
            } else {
                readInput.nextLine();
                continue;
            }
            
            parsedDouble = readInput.nextDouble();
            readInput.nextLine();
            
            if (parsedDouble < min || parsedDouble > max) {
                inputIsValid = false;
            }
        }
        return parsedDouble;        
    }

    @Override
    public float readFloat(String prompt) {
        float parsedFloat = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextFloat()) {
                inputIsValid = true;
            } else {
                readInput.nextLine();
                continue;
            }
            
            parsedFloat = readInput.nextFloat();
            readInput.nextLine();
        }
        return parsedFloat; 
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float parsedFloat = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextFloat()) {
                inputIsValid = true;
            } else {
                readInput.nextLine();
                continue;
            }
            
            parsedFloat = readInput.nextFloat();
            readInput.nextLine();
            
            if (parsedFloat < min || parsedFloat > max) {
            inputIsValid = false;
            }
        }
        return parsedFloat; 
    }

    @Override
    public int readInt(String prompt) {
        int parsedInt = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextInt()) {
                inputIsValid = true;
            } else {
                readInput.nextLine();
                continue;
            }
            
            parsedInt = readInput.nextInt();
            readInput.nextLine();
        }
        return parsedInt; 
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int parsedInt = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextInt()) {
                inputIsValid = true;
            } else {
                continue;
            }
            
            parsedInt = readInput.nextInt();
            readInput.nextLine();
            
            if (parsedInt < min || parsedInt > max) {
                inputIsValid = false;
            }
        }
        return parsedInt;    
    }

    @Override
    public long readLong(String prompt) {
        long parsedLong = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextDouble()) {
                inputIsValid = true;
            } else {
                readInput.nextLine();
                continue;
            }
            
            parsedLong = readInput.nextLong();
            readInput.nextLine();
        }
        return parsedLong; 
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long parsedLong = 0;
        boolean inputIsValid = false;
        
        while (!inputIsValid) {
            
            print(prompt);
            
            if (readInput.hasNextDouble()) {
                inputIsValid = true;
            } else {
                readInput.nextLine();
                continue;
            }
            
            parsedLong = readInput.nextLong();
            readInput.nextLine();
            
            if (parsedLong < min || parsedLong > max) {
                inputIsValid = false;
            }
        }
        return parsedLong; 
    }

    @Override
    public String readString(String prompt) {

        String parsedString = readInput.nextLine();
        return parsedString; 
    }    
    
}
    

