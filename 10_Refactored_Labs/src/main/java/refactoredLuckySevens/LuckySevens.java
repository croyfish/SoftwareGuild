/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoredLuckySevens;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jeffc
 */
public class LuckySevens {
    
    public void playLuckySevensGame() {
        
        Scanner readInput = new Scanner(System.in);
        Random randomizer = new Random();
        int moneyHave = 0;
        
        while (moneyHave < 1) {
            System.out.print("How many dollars do you have? ");
            moneyHave = readInput.nextInt();
            readInput.nextLine();
            if (moneyHave < 1) {
                System.out.println("Please enter an amount greater than zero.");
            }
        }
        
        int rolls = 0, maxMoney = moneyHave, maxRolls = 0;
        int diceTotal, currentMoney = moneyHave;
        
        while (currentMoney > 0) {

            diceTotal = randomizer.nextInt(6) + randomizer.nextInt(6) + 2;
            rolls++;
            
            if (diceTotal == 7) {
                currentMoney += 4;
            } else {
                currentMoney -= 1;
            }
            
            if (currentMoney > maxMoney) {
                maxMoney = currentMoney;
                maxRolls = rolls;
            }
        }
        
        System.out.println("You are broke after " + rolls + " rolls.");
        System.out.println("You should have quit after " + maxRolls + " rolls when you had $" + maxMoney);
    }
}
