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
    private LocationCommandModel location;
    
    @NotEmpty(message = "You must supply a value for phone.")
    @Length(min = 2, max = 15, message = "Phone must be between 2 and 15 characters in length.")  
    private String phone;
    
    private Boolean isGood;
    
    private Integer[] superPersonsInOrg;

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

    public LocationCommandModel getLocation() {
        return location;
    }

    public void setLocation(LocationCommandModel location) {
        this.location = location;
    }

    public Integer[] getSuperPersonsInOrg() {
        return superPersonsInOrg;
    }

    public void setSuperPersonsInOrg(Integer[] superPersonsInOrg) {
        this.superPersonsInOrg = superPersonsInOrg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsGood() {
        return isGood;
    }

    public void setIsGood(Boolean isGood) {
        this.isGood = isGood;
    }    
    
    
}
