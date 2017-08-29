/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsguild.classmodeleing;

/**
 *x coor
 * y coor
 * st. name
 * house num
 * state
 * 
 * search by num/street
 * find routes to
 * return lat/long of address
 * zoom in to house
 * find directions from house
 * 
 * @author jeffc
 */
public class House1 {
    private float xCoordinate;
    private float yCoordinate;
    private String streetName;
    private String houseNum;
    private String state;

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public double[] searchByAddress(String houseNum, String streetName) {
        
    }
    
    public Route() findRoutesTo(int houseNum, String streetName) {
   
    }
    
    public double[] getCoordinates(int houseNum, String streetName) {
        
    }
    
    public double[] zoomInToHouse(int houseNum, String streetName) {
    
    }
    
    public Route() findRoutesFrom(int houseNum, String streetName, String[] currentIntersection) {
    
    }
}
