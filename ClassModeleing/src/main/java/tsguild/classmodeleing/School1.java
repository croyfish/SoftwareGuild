/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsguild.classmodeleing;

/**
 *
 * @author jeffc
 */
public class School1 {
    private String name;
    private String description;
    private int numberOfClassrooms;
    private double squareFootage;
    private int addressCapacity;
    private Cafeteria cafeteria;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfClassrooms() {
        return numberOfClassrooms;
    }

    public void setNumberOfClassrooms(int numberOfClassrooms) {
        this.numberOfClassrooms = numberOfClassrooms;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getStudentCapacity() {
        return addressCapacity;
    }

    public void setStudentCapacity(int addressCapacity) {
        this.addressCapacity = addressCapacity;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }
    
    
}
