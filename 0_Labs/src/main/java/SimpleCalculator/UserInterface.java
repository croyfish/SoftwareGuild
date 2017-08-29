package SimpleCalculator;

import java.util.Scanner;
/**
 *
 * @author jeffc
 */
public class UserInterface {
    
    public void handleIO() {
        
        Scanner readInput = new Scanner(System.in);
        
        
    while (true) {
        
        boolean inputIsValid = false;
        
        int choice = 0;
        double operand1, operand2;
        
        while (!inputIsValid) {
        
            System.out.println("Choose your own adventure.");
            System.out.println("1) add   2) subract   3) multiply   4) divide   5) exit");
        
            choice = readInput.nextInt();
            readInput.nextLine();
        
            if (choice > 0 && choice < 6) {
                inputIsValid = true;
            } else {
                System.out.println("Your input is funky.");
            }
        }
        
        if (choice == 5) {
            System.out.println("Thank you for playing.");
            return;
        }
        
        System.out.println("Enter operand 1.");
        
        operand1 = readInput.nextDouble();
        readInput.nextLine();
        
        System.out.println("Enter operand 2.");
        
        operand2 = readInput.nextDouble();
        readInput.nextLine();

        System.out.print("The result is: ");
        
        switch (choice) {
            case 1:
                System.out.print(Calculator.addNumbers(operand1, operand2));
                break;
            case 2:
                System.out.print(Calculator.subtractNumbers(operand1, operand2));
                break;
            case 3:
                System.out.print(Calculator.multiplyNumbers(operand1, operand2));
                break;
            case 4:
                System.out.print(Calculator.divideNumbers(operand1, operand2));
                break;
        }
    
        System.out.println("");
        
        
        }
            
    }
        
}
