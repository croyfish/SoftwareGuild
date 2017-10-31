/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.commandmodel;

import com.sg.superherosightings.model.Address;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jeffc
 */
public class LocationCommandModel {
    
private Integer locationId;

    @NotEmpty(message = "You must supply a value for name.")
    @Length(max = 50, message = "Name must be no more than 50 characters in length.")    
    private String name;
      
    @Length(max = 65535, message = "Description must be no more than 65,535 characters in length.") 
    private String description;
       
    @NotEmpty(message = "You must supply an address.")
    private AddressCommandModel address;
    
    @NotEmpty(message = "You must supply a value for latitude.")
    @Length(min = 9, max = 50, message = "Coordinate values must be between 9 and 50 characters in length.")       
    private String latitude;
    
    @NotEmpty(message = "You must supply a value for longitude.")
    @Length(min = 9, max = 50, message = "Coordinate values must be between 9 and 50 characters in length.")           
    private String longitude;
    
    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
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
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }    

    public AddressCommandModel getAddress() {
        return address;
    }

    public void setAddress(AddressCommandModel address) {
        this.address = address;
    }
    
}
