/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reoccurencerelation;

/**
 *
 * @author luqma
 */
import java.util.Scanner;
import java.io.*;
public class ReoccurenceRelation {

    public static void main(String[] args) {
    int array[] = new int[10];
    String arrayStr[] = new String[10];
    Scanner input = new Scanner(System.in);
    int c = input.nextInt();
    int a_zero = input.nextInt();
    array[0] = recurRelation(c, a_zero);
    for(int i = 1; i<10; i++){
        array[i] = recurRelation(c, array[i-1]);
        }
    for(int k = 0; k<10; k++){
        arrayStr[k] = Integer.toString(array[k]);
    }
    
    //write to csv
    String csv = "";
    for(int j = 0; j<10; j++){
    csv = String.join(",", arrayStr);
    }
    try {
    printToCSV(csv);
    }
    catch(IOException e) {
    e.printStackTrace();
    }
    
    }
    public static int recurRelation(int c, int a){
        int an = (c*a);
        System.out.println(an);
        return an;
    }
    
    static void printToCSV(String csv) throws IOException{ //print order using File I/O
        try{
        String nameOfFile = "array.csv";
        BufferedWriter file = new BufferedWriter(new FileWriter(nameOfFile));
        file.write(csv);
        file.close();
        System.out.println(nameOfFile+" successfully printed!");
        }
        catch(IOException e) {
        e.printStackTrace();
        }
    }
}
    
