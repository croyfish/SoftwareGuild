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
public class Triangle extends Shape {
    private double sideA, sideB, sideC;
    
    @Override
    public double getArea(){
        double area = 0;
        double p = this.getPerimeter();
        area = Math.sqrt((p) * (p - sideA) * (p - sideB) * (p - sideC));
        return area;
    }
    
    @Override
    public double getPerimeter() {
        double area = sideA + sideB + sideC;
        return area;
    }
         
    public double getSideA() {
        return sideA;
    }

    public void setSideA(double newSideA) {
        this.sideA = newSideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double newSideB) {
        this.sideB = newSideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double newSideC) {
        this.sideC = newSideC;
    }
    
    
}
