package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        int lettersCount = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            int currentByte;

            while((currentByte = reader.read()) != -1) {
                if(currentByte >= 'A' && currentByte <= 'z' ) {
                    lettersCount++;
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(lettersCount);
    }
}
