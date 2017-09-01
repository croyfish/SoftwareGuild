/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsguild.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jeffc
 */
public class SimpleFileIO {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        
        out.println("this is a line in my file...");
        out.println("this is a second line in my file...");
        out.println("this is a third line in my file...");
        out.flush();
        out.close();
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
        
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
    }
}
