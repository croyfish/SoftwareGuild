/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaysOfTheWeek;
import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class App {
    public static void main(String[] args) {
        
        
        System.out.println("What Day is it?");
        Scanner readInput = new Scanner(System.in);
        Days day = Days.valueOf(readInput.nextLine().toUpperCase());
        int daysUntilFriday = returnDaysUntilFriday(day);
        System.out.println("There are " + daysUntilFriday + " until Friday!");
        
    }
    
     public static int returnDaysUntilFriday(Days day) {
         switch(day) {
                case MONDAY:
                      return 4;
                case TUESDAY:
                      return 3;
                case WEDNESDAY:
                      return 2;
                case THURSDAY:
                      return 1;
                case FRIDAY:
                    return 0;
                case SATURDAY:
                    return 6;
                case SUNDAY:
                    return 5;
                default:
                      throw new UnsupportedOperationException();
         }
    }
}
