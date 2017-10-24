/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.helpers;

import java.lang.reflect.Field;

/**
 *
 * @author jeffc
 */
public class ObjectsAreEqual {
    
    public boolean objectsAreEqual(Object o1, Object o2) {
        Class testClass = o1.getClass();
        Field[] fields = testClass.getDeclaredFields();
        boolean allTrue = true;
        String results = "Got here.";
        
        try {
            for (int i=0; i< fields.length; i++)
            {
                Field currentField = fields[i];
                currentField.setAccessible(true);
                System.out.print(i);
                //results = currentField.get(o1).toString();
                System.out.println(currentField.get(o1));
                System.out.println("Got HERE");
            }
        } catch (IllegalAccessException e){
            System.out.println("Exceptoin!!!!!!");
        }
        
        return allTrue;
    }
    
}
