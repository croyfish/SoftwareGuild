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
public class Circle extends Shape {
    private final static double PI = 3.1415;
    private double radius = 0;
    
    @Override
    public double getArea(){
        double area = PI * radius * radius;
        return area;
    }
    
    @Override
    public double getPerimeter() {
        double area = 2 * PI * radius;
        return area;
    }
    
    public double getRadius() {
        return this.radius;
    }
    
    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }    
}
