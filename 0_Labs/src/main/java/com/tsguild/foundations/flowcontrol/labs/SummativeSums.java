
package com.tsguild.foundations.flowcontrol.labs;

/**
 * Finished
 * @author jeffc
 */
public class SummativeSums {
    
    public static void main(String[] args) {
        
        // Declare & initialize test arrays from specifications.
        int[] intArray1 = {1, 90, -33, -55, 67,
            -16, 28, -55, 15 };
        int[] intArray2 = {999, -60, -77, 14, 160, 301 };
        int[] intArray3 = {10, 20, 30, 40, 50, 60, 70, 80,
            90, 100, 110, 120, 130, 140, 150, 160, 170,
            180, 190, 200, -99 };
        
        // Decalare array sums.
        int sum1, sum2, sum3;
        
        // Call sumIntArray method to sum the elements of each array
        // and store in sum variables.
        sum1 = sumIntArray(intArray1);
        sum2 = sumIntArray(intArray2);
        sum3 = sumIntArray(intArray3);
        
        // Print sum of each array out to console.
        System.out.println("#1 Array Sum: " + sum1);
        System.out.println("#2 Array Sum: " + sum2);
        System.out.println("#3 Array Sum: " + sum3);
        
    }
    
    // This method takes in an integer array as a paramenter,
    // sums all of its elements, 
    // and returns the result as an integer
    public static int sumIntArray(int[] arrayToSum) {
        
        // Declare array sum variable.
        int arraySum = 0;
        
        // Enhanced for loop that runs from index 0
        // to the last element of the array, extracts
        // each element in sequence to the variable num,
        // and sums the elements inside of the loop.
        for (int num : arrayToSum) {
            arraySum += num;
        }
        
        // The sum of the array is returned from
        // the method call as an integer.
        return arraySum;
    }
}
