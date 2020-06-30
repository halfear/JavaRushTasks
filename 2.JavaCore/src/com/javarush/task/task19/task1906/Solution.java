package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] fileNames = readFilename();

        copyBytes(fileNames);
    }

    private static String[] readFilename() throws IOException {
        String[] result = new String[2];

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            result[0] = reader.readLine();
            result[1] = reader.readLine();
        }
        return result;
    }

    private static void copyBytes(String[] fileNames) throws IOException {
        try(FileReader reader = new FileReader(fileNames[0]);
            FileWriter writer = new FileWriter(fileNames[1])) {
            int symbol;
            int count = 1;

            while((symbol = reader.read()) != -1) {
                if((count % 2) == 0) {
                    writer.append((char) symbol);
                }
                count++;
            }
        }
    }
}
