/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathOperators;

/**
 *
 * @author jeffc
 */

    public class IntMath {
        public static int calculate(MathOperators operator, int operand1, int operand2) {
            switch(operator) {
                case ADD:
                      return operand1 + operand2;
                case SUBTRACT:
                      return operand1 - operand2;
                case MULTIPLY:
                      return operand1 * operand2;
                case DIVIDE:
                      return operand1 / operand2;
                default:
                      throw new UnsupportedOperationException();
            }
        }
    }
