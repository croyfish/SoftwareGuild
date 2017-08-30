/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShapesAndPerimeters;

/**
 *
 * @author jeffc
 */
public class Square extends Shape {
    
    private double side;
    
    @Override
    public double getArea(){
        double area = side * side;
        return area;
    }
    
    @Override
    public double getPerimeter() {
        double area = 4 * side;
        return area;
    }
    
    public double getSide() {
        return this.side;
    }
    
    public void setSide(double newSide) {
        this.side = newSide;
    }
    
}
