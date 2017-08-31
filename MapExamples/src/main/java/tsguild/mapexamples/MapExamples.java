/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsguild.mapexamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jeffc
 */
public class MapExamples {
    public static void main(String[] args) {
        Map<String, Integer> populations = new HashMap<>();
        
        populations.put("USA", 313000000);
        
        populations.put("Canada", 34000000);
        
        populations.put("United Kingdom", 127000000);
        
        populations.put("Japan", 127000000);
        
        System.out.println("Map size is: " + populations.size());
        
        Collection<Integer> populationValues = populations.values();
        
        for (Integer currentPopulation : populationValues) {
            System.out.println(currentPopulation);
        }

    }
}
