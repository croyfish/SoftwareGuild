/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathOperators;
import static DaysOfTheWeek.App.returnDaysUntilFriday;
import DaysOfTheWeek.Days;
import static MathOperators.MathOperators.ADD;
import static MathOperators.MathOperators.DIVIDE;
import static MathOperators.MathOperators.MULTIPLY;
import static MathOperators.MathOperators.SUBTRACT;
import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class App {
    public static void main(String[] args) {
        
        Scanner readInput = new Scanner(System.in);
        System.out.println("Enter Operand 1");
        int operand1 = readInput.nextInt();
        readInput.nextLine();
        System.out.println("Enter Operand 1");
        int operand2 = readInput.nextInt();
        readInput.nextLine();       
        System.out.println(IntMath.calculate(ADD, operand1, operand2));
        System.out.println(IntMath.calculate(SUBTRACT, operand1, operand2));
        System.out.println(IntMath.calculate(MULTIPLY, operand1, operand2));
        System.out.println(IntMath.calculate(DIVIDE, operand1, operand2));
        
        
        Days day = Days.valueOf(readInput.nextLine().toUpperCase());
        int daysUntilFriday = returnDaysUntilFriday(day);
        System.out.println("There are " + daysUntilFriday + " until Friday!");
        
    }
    
}
    
