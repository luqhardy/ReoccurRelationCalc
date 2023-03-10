package com.mycompany.reoccurencerelation;
/**
 *
 * MOHAMED LUQMAN HADI BIN MOHAMED SUHAIRI
 * MUAZZAM HAZMI BIN SUKHAIMI
 * SYAHIR
 * MIRZA DARWISY
 * MATHS FOR COMPUTING: CODE FOR CALCULATING REOCCURENCE RELATION AND OUTPUT AS CSV
 */
import java.util.Scanner;
import java.io.*;
public class ReoccurenceRelation {

    public static void main(String[] args) {
    int array[] = new int[10];
    int array2[] = new int[10];
    String arrayStr[] = new String[10];
    String arrayStr2[] = new String[10];
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the value for C: ");
    int c = input.nextInt();
    System.out.print("Enter the value for a(0): ");
    int a_zero = input.nextInt();
    array[0] = recurRelation(c, a_zero);
    for(int i = 1; i<10; i++){
        array[i] = recurRelation(c, array[i-1]);
        }
    for(int k = 0; k<10; k++){
        arrayStr[k] = Integer.toString(array[k]);
    }
    System.out.println("Now recurRalationModified will be called. \n This is the formula for recurRelation but modified. \n an = (c*a)-(c*(a*a)) ");
    System.out.print("Enter the value for C: ");
    c = input.nextInt();
    System.out.print("Enter the value for a(0): ");
    a_zero = input.nextInt();
    array2[0] = recurRelationModified(c, a_zero);
    for(int i = 1; i<10; i++){
        array2[i] = recurRelationModified(c, array2[i-1]);
        }
    for(int k = 0; k<10; k++){
        arrayStr2[k] = Integer.toString(array2[k]);
    }
    
    //write to csv
    String[] csv = new String[10];
    String[] csv2 = new String[10];
    for(int j = 0; j<10; j++){
        csv[j] = Integer.toString(j) + "," + arrayStr[j];
        csv2[j] = Integer.toString(j) + "," + arrayStr2[j];    
    }
    try {
            printToCSV(csv, "recur1");
            printToCSV(csv2, "recur2");

        }
            catch(IOException e) {
            e.printStackTrace();
        }    

    
    }
    public static int recurRelation(int c, int an_minusone){
        int an = (c*an_minusone);
        System.out.println(an);
        return an;
    }
    public static int recurRelationModified(int c, int a){
        int an = (c*a)-(c*(a*a));
        System.out.println(an);
        return an;
    }
    
    static void printToCSV(String csv[], String fileName) throws IOException{
        try{
        String nameOfFile = fileName +".csv";
        BufferedWriter file = new BufferedWriter(new FileWriter(nameOfFile));
            for(int i=0;i<csv.length;i++){
                file.write(csv[i]);
                file.write("\n");  
            }
            file.close();
        System.out.println(fileName + " Exported as .csv");    
        }
        catch(IOException e) {
        e.printStackTrace();
        }
    }
    
}
    
