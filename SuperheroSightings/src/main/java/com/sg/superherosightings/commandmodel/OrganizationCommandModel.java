/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.commandmodel;

import com.sg.superherosightings.model.Location;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jeffc
 */
public class OrganizationCommandModel {
    
 private Integer organizationId;
    
    @NotEmpty(message = "You must supply a value for name.")
    @Length(max = 50, message = "Name must be no more than 50 characters in length.")     
    private String name;
    
    @Length(max = 65535, message = "Description must be no more than 65,535 characters in length.")    
    private String description;
    
    @NotEmpty(message = "You must supply a location.")
    private Integer locationId;
    
    @NotEmpty(message = "You must supply a value for phone.")
    @Length(min = 2, max = 15, message = "Phone must be between 2 and 15 characters in length.")  
    private String phone;
    
    private String isGood;
    
    private Integer[] superPersons;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer[] getSuperPersons() {
        return superPersons;
    }

    public void setSuperPersons(Integer[] superPersons) {
        this.superPersons = superPersons;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsGood() {
        return isGood;
    }

    public void setIsGood(String isGood) {
        this.isGood = isGood;
    }
    
}
