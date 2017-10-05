/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensspringmvc;

import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jeffc
 */
@Controller
public class LuckySevensController {
    @RequestMapping(value="/playGame", method=RequestMethod.POST)
    public String playGame(HttpServletRequest request, Map<String, Object> model) {
        
       // inputs
        Integer moneyToBet = 0;
        
        // intermediaries
        Integer currentMoney = 0;
        Integer currentRoll = 0;
        Random dice1 = new Random();
        Random dice2 = new Random();
        Integer currentTotal = 0;
        
        // outputs
        Integer numberOfRollsTaken = 0;
        Integer maxAmountOfMoney = 0;
        Integer numberOfRollsAtMax = 0;
        
        // get inputs
        String moneyToBetString = request.getParameter("moneyToBet");
        moneyToBet = Integer.parseInt(moneyToBetString);        
        
        // calculate intermediate values
        currentMoney = moneyToBet;
        maxAmountOfMoney = currentMoney;
        
        // game loop
        
        while (!currentMoney.toString().equals("0")) {
            currentRoll++;
            currentTotal = dice1.nextInt(6) + dice2.nextInt(6) + 2;
            if (currentTotal == 7) {
                currentMoney += 4;
            } else {
                currentMoney -= 1;
            }
            if (currentMoney > maxAmountOfMoney) {
                maxAmountOfMoney = currentMoney;
                numberOfRollsAtMax = currentRoll;
            }
        }
        
        numberOfRollsTaken = currentRoll;
        
        request.setAttribute("moneyToBet", moneyToBet);
        request.setAttribute("numberOfRollsTaken", numberOfRollsTaken);
        request.setAttribute("maxAmountOfMoney", maxAmountOfMoney);
        request.setAttribute("numberOfRollsAtMax", numberOfRollsAtMax);  
        
        model.put("moneyToBet", moneyToBet);
        model.put("numberOfRollsTaken", numberOfRollsTaken);
        model.put("maxAmountOfMoney", maxAmountOfMoney);
        model.put("numberOfRollsAtMax", numberOfRollsAtMax);
        return "result";        
    }
    
}
