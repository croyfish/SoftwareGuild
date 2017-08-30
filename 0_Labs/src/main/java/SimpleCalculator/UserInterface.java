package SimpleCalculator;

/**
 *
 * @author jeffc
 */
public class UserInterface {
    
    public void handleIO() {
        
        UserIO IO = new IOHandler();
        
    while (true) {
                
        int choice = 0;
        double operand1, operand2;
        
        
        IO.print("Choose your own adventure.");
        choice = IO.readInt("1) add   2) subract   3) multiply   4) divide   5) exit", 1, 5);
        
        
        if (choice == 5) {
            IO.print("Thank you for playing.");
            return;
        }
        
        operand1 = IO.readDouble("Enter operand 1.");
        
        operand2 = IO.readDouble("Enter operand 2.");


        IO.print("The result is: ");
        
        switch (choice) {
            case 1:
                System.out.println(Calculator.addNumbers(operand1, operand2));
                break;
            case 2:
                System.out.println(Calculator.subtractNumbers(operand1, operand2));
                break;
            case 3:
                System.out.println(Calculator.multiplyNumbers(operand1, operand2));
                break;
            case 4:
                System.out.println(Calculator.divideNumbers(operand1, operand2));
                break;
        }
    
        IO.print("");
        
        
        }
            
    }
        
}
