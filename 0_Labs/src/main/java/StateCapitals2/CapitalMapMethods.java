/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateCapitals2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jeffc
 */
public class CapitalMapMethods {
    Map<String, String> capitals = new HashMap<>();
    Map<String, Capital> capitalObjects = new HashMap<>();
    Map<String, Integer> stateNumbers = new HashMap<>();
    Set<String> capitalKeys = capitals.keySet();
    Set<String> capitalObjectKeys = capitalObjects.keySet();
    
    public void initializeCaptials() {
        capitals.put("Alabama","Montgomery");
	capitals.put("Alaska","Juneau");
        capitals.put("Arizona","Phoenix");        
        capitals.put("Arkansas","Little Rock");        
        capitals.put("California","Sacramento");        
        capitals.put("Colorado","Denver");        
        capitals.put("Connecticut","Hartford");        	
        capitals.put("Delaware","Dover");        
        capitals.put("Florida","Tallahassee");        
        capitals.put("Georgia","Atlanta");        
        capitals.put("Hawaii","Honolulu");       
        capitals.put("Idaho","Boise");        
        capitals.put("Illinois","Springfield");        
        capitals.put("Indiana","Indianapolis");       
        capitals.put("Iowa","Des Moines");        
        capitals.put("Kansas","Topeka");        
        capitals.put("Kentucky","Frankfort");        
        capitals.put("Louisiana ","Baton Rouge");        
        capitals.put("Maine","Augusta");        
        capitals.put("Maryland ","Annapolis");        
        capitals.put("Massachusetts","Boston");        
        capitals.put("Michigan","Lansing");        
        capitals.put("Minnesota ","St. Paul");        
        capitals.put("Mississippi","Jackson");        
        capitals.put("Missouri","Jefferson City");        
        capitals.put("Montana","Helena");        
        capitals.put("Nebraska","Lincoln");        	
        capitals.put("Nevada","Carson City");        	
        capitals.put("New Hampshire","Concord");        
        capitals.put("New Jersey","Trenton");        
        capitals.put("New Mexico","Santa Fe");        	
        capitals.put("New York","Albany");        	
        capitals.put("North Carolina","Raleigh");        	
        capitals.put("North Dakota","Bismarck");        	
        capitals.put("Ohio","Columbus");        	
        capitals.put("Oklahoma","Oklahoma City");        	
        capitals.put("Oregon","Salem");        
        capitals.put("Pennsylvania","Harrisburg");        	
        capitals.put("Rhode Island","Providence");        
        capitals.put("South Carolina","Columbia");        	
        capitals.put("South Dakota","Pierre");        
        capitals.put("Tennessee","Nashville");        
        capitals.put("Texas","Austin");        	
        capitals.put("Utah","Salt Lake City");        	
        capitals.put("Vermont","Montpelier");        
        capitals.put("Virginia","Richmond");        	
        capitals.put("Washington","Olympia");        
        capitals.put("West Virginia","Charleston");        	
        capitals.put("Wisconsin","Madison");        
        capitals.put("Wyoming ","Cheyenne");

        stateNumbers.put("Alabama",1);
	stateNumbers.put("Alaska",2);
        stateNumbers.put("Arizona",3);        
        stateNumbers.put("Arkansas",4);        
        stateNumbers.put("California",5);        
        stateNumbers.put("Colorado",6);        
        stateNumbers.put("Connecticut",7);        	
        stateNumbers.put("Delaware",8);        
        stateNumbers.put("Florida",9);        
        stateNumbers.put("Georgia",10);        
        stateNumbers.put("Hawaii",11);       
        stateNumbers.put("Idaho",12);        
        stateNumbers.put("Illinois",13);        
        stateNumbers.put("Indiana",14);       
        stateNumbers.put("Iowa",15);        
        stateNumbers.put("Kansas",16);        
        stateNumbers.put("Kentucky",17);        
        stateNumbers.put("Louisiana ",18);        
        stateNumbers.put("Maine",19);        
        stateNumbers.put("Maryland ",20);        
        stateNumbers.put("Massachusetts",21);        
        stateNumbers.put("Michigan",22);        
        stateNumbers.put("Minnesota ",23);        
        stateNumbers.put("Mississippi",24);        
        stateNumbers.put("Missouri",25);        
        stateNumbers.put("Montana",26);        
        stateNumbers.put("Nebraska",27);        	
        stateNumbers.put("Nevada",28);        	
        stateNumbers.put("New Hampshire",29);        
        stateNumbers.put("New Jersey",30);        
        stateNumbers.put("New Mexico",31);        	
        stateNumbers.put("New York",32);        	
        stateNumbers.put("North Carolina",33);        	
        stateNumbers.put("North Dakota",34);        	
        stateNumbers.put("Ohio",35);        	
        stateNumbers.put("Oklahoma",36);        	
        stateNumbers.put("Oregon",37);        
        stateNumbers.put("Pennsylvania",38);        	
        stateNumbers.put("Rhode Island",39);        
        stateNumbers.put("South Carolina",40);        	
        stateNumbers.put("South Dakota",41);        
        stateNumbers.put("Tennessee",42);        
        stateNumbers.put("Texas",43);        	
        stateNumbers.put("Utah",44);        	
        stateNumbers.put("Vermont",45);        
        stateNumbers.put("Virginia",46);        	
        stateNumbers.put("Washington",47);        
        stateNumbers.put("West Virginia",48);        	
        stateNumbers.put("Wisconsin",49);        
        stateNumbers.put("Wyoming",50);
        
    }
    
    public void instantiateCapitals() {
        int stateIndex;
        int[] populations = {205764, 31275, 1445632, 193524, 466488, 600158,
                        124512, 36047, 181412, 420003, 337256, 205671, 116250,
                        829718, 203433, 127473, 25527, 229553, 19136, 38394,
                        617594, 114297, 285068, 173514, 43079, 28190, 258379,
                        55274, 42695, 84913, 75764, 97856, 403892, 61272,
                        787033, 580000, 154637, 49528, 178042, 131686, 13646,
                        635710, 842592, 186440, 7855, 204214, 46478, 51400,
                        233209, 59466};
        double[] squareAreas = {155.4, 2716.7, 474.9, 116.2, 97.2, 153.4, 17.3,
                        22.4, 95.7, 131.7, 85.7, 63.8, 54, 361.5, 75.8, 56,
                        14.7, 76.8, 55.4, 6.73, 48.4, 35, 52.8, 104.9, 27.3,
                        14, 74.6, 143.4, 64.3, 7.66, 37.3, 21.4, 114.6, 26.9,
                        210.3, 607, 45.7, 8.11, 18.5, 125.2, 13, 473.3, 251.5,
                        109.1, 10.2, 60.1, 16.7, 31.6, 68.7, 21.1};
        
        
        for (String currentCapital : capitalKeys) {
            Capital myCapital = new Capital();
            myCapital.setCapitalName(capitals.get(currentCapital));
            stateIndex = stateNumbers.get(currentCapital);
            capitalObjects.put(currentCapital, myCapital);
            System.out.println(myCapital);
            myCapital.setCapitalPopulation(populations[stateIndex - 1]);
            myCapital.setCapitalSquareMileage(squareAreas[stateIndex - 1]);
        }
    }
    
    public void printStateCapitalPairs() {
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");

            for (String stateName : capitalKeys) {
                Capital capitalObject = new Capital();
                capitalObject = capitalObjects.get(stateName); 
                System.out.print(stateName + " - " + capitalObject.getCapitalName() + " | Pop "
                    + capitalObject.getCapitalPopulation() + " | Area: " 
                            + capitalObject.getCapitalSquareMileage() +
                            " sq mi");
                System.out.println("");
            }
    }
    
        public void printStateCapitalPairsOver() {
            Scanner readInput = new Scanner(System.in);
            


            System.out.print("What is your minimum population? ");
            int minPop = readInput.nextInt();
            readInput.nextLine();
            
            System.out.println("LISTING CAPITALS WITH BLAH BLAH BLAH");
        
        
            for (String stateName : capitalKeys) {
                Capital capitalObject = new Capital();
                capitalObject = capitalObjects.get(stateName);
                
                if (capitalObject.getCapitalPopulation() > minPop) {
                System.out.print(stateName + " - " + capitalObject.getCapitalName() + " | Pop "
                    + capitalObject.getCapitalPopulation() + " | Area: " 
                            + capitalObject.getCapitalSquareMileage() +
                            " sq mi");
                System.out.println("");
                }
            }
    }
}
