/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

/**
 *
 * @author jeffc
 */
public interface UserIO {
    
    void print(String message);
    
    void print(double message);
    
    void print(float message);
    
    void print(int message);
    
    void print(long message);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);
    
    Integer readInteger(String prompt);
    
    Integer readInteger(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);
}