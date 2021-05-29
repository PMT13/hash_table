// Parts of this code and java file are not written by me. I originally got this file off of the
// CSCI 1933 Spring 2020 Canvas page and only altered it to fit the requirements of Project 5.
import java.util.Scanner;
import java.io.*;

public class TextScan {
    String filename;

    public TextScan(String file){
        filename = file;
    }

    public String[] fileArray() throws FileNotFoundException {
        Scanner readFile = null;
        String s;
        int count = 0;
        int idx = 0 ;
        boolean contains = false;

        System.out.println();
        System.out.println("Attempting to read from file: " + filename);            // this part tries to read the file and was not written by me (credits above)
        try {
            readFile = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + filename + " not found");
            System.exit(1);
        }

        System.out.println("Connection to file: " + filename + " successful");
        System.out.println();
        while (readFile.hasNext()) {
            s = readFile.next();
            count++;                                // count keeps track of how many tokens there are
        }
        String[] arr = new String[count];           // initializes an array to the number of tokens found in the file
        readFile = new Scanner(new File(filename));
        while (readFile.hasNext()) {                // this is where we actually add the tokens to the array
            contains = false;
            String t = readFile.next();
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != null) {
                    if (arr[i].equals(t)) {        // if the token is already in the array, it will not be added
                        contains = true;
                    }
                }
            }
            if (contains == false) {               // this makes it so that if the token was not found in the array already
                arr[idx] = t;                      // it's added to the array
                idx++;                             // idx is a variable to keep track of the next open slot in the array
            }
        }
        String[] newArr = new String[idx];         // this re-sizes the array to the number of unique tokens there are in the file
        for(int x = 0; x < newArr.length; x++){    // this is where we copy the tokens from the old array to the new re-sized one
            newArr[x] = arr[x];
        }
        return newArr;
    }
}