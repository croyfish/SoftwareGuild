/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdas.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeffc
 */
public class ServerDaoInMemImpl implements ServerDao {
    
    private Map<String, Server> serverMap = new HashMap<>();

    @Override
    public void addServer(Server server) {
        serverMap.put(server.getName(), server);
    }

    @Override
    public Server getServer(String name) {
        return serverMap.get(name);
    }

    @Override
    public void removeServer(String name) {
        serverMap.remove(name);
    }

    @Override
    public List<Server> getAllServers() {
        return new ArrayList(serverMap.values());   
    }

    
    @Override
    public Map<String, List<Server>> getAllServersGroupByManufacturer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Server> getServersByManufacturer(String manufacturer) {
        List<Server> results = new ArrayList();
        List<Server> allServers = getAllServers();
        
        allServers.stream().filter((s) -> (manufacturer.equals(s.getManufacturer()))).forEachOrdered((s) -> {
            results.add(s);
        });
        
        return results;
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAverageServerAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
