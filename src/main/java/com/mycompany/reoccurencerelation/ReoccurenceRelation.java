package com.mycompany.reoccurencerelation;
/**
 *
 * MOHAMED LUQMAN HADI BIN MOHAMED SUHAIRI
 * 2210855
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
    System.out.println("Now recurRalationModified will be called");
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
    String csv = "";
    for(int j = 0; j<10; j++){
    csv = String.join(",", arrayStr);
    }
    String csv2 = "";
    for(int j = 0; j<10; j++){
    csv2 = String.join(",", arrayStr2);
    }
    
    try {
    printToCSV(csv);
    printToCSV(csv2);
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
    public static int recurRelationModified(int c, int a){
        int an = (c*a)-(c*(a*a));
        System.out.println(an);
        return an;
    }
    
    static void printToCSV(String csv) throws IOException{ //print order using File I/O
        Scanner input = new Scanner(System.in);
        try{
        System.out.print("Enter name of file you prefer: "); 
        String nameOfFile = input.nextLine() +".csv";
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
    
