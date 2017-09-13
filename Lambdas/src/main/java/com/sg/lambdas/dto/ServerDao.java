/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdas.dto;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public interface ServerDao {
    
    // CRUD methods
    public void addServer(Server server);
    public Server getServer(String name);
    public void removeServer(String name);
    public List <Server> getAllServers();
    
    // Take input, return lists of servers
    public Map<String, List<Server>> getAllServersGroupByManufacturer();
    public List<Server> getServersByManufacturer(String manufacturer);
    public List<Server> getServersOlderThan(int ageInYears);
    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears);
    
    // Get age of current server only
    public double getAverageServerAge();    
    
}
