/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsguild.classmodeleing;

/**
 * lat coord
 * long coord
 * altitude
 * direction
 * speed
 * @author jeffc
 */
public class Airplane1 {
    private double latitudeCoordinate;
    private double longitudeCoordinate;
    private double altitude;
    private double direction;
    private double speed;

    public double getLatitudeCoordinate() {
        return latitudeCoordinate;
    }

    public void setLatitudeCoordinate(double latitudeCoordinate) {
        this.latitudeCoordinate = latitudeCoordinate;
    }

    public double getLongitudeCoordinate() {
        return longitudeCoordinate;
    }

    public void setLongitudeCoordinate(double longitudeCoordinate) {
        this.longitudeCoordinate = longitudeCoordinate;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    
}
