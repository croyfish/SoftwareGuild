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
public class Rectangle extends Shape {
    private double length = 0;
    private double width = 0;
    
    @Override
    public double getArea(){
        double area = length * width;
        return area;
    }
    
    @Override
    public double getPerimeter() {
        double area = length + length + width + width;
        return area;
    }
    
    public double getLength() {
        return this.length;
    }
    
    public void setLength(double newLength) {
        this.length = newLength;
    }

    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(double newWidth) {
        this.width = newWidth;
    }    
    
}
