package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    private static final char SYMBOL_OUT = '.';
    private static final char SYMBOL_IN = '!';

    public static void main(String[] args) throws IOException {
        String[] fileNames = readFileName();
        String source = fileNames[0];
        String destination = fileNames[1];

        replace(source, destination, SYMBOL_OUT, SYMBOL_IN);
    }

    private static String[] readFileName() throws IOException {
        String[] names = new String[2];

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            names[0] = reader.readLine();
            names[1] = reader.readLine();
        }
        return names;
    }

    private static void replace(String source, String destination, char symbolOut, char symbolIn) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            int ch;

            while((ch = reader.read()) != -1) {
                if((char) ch == symbolOut) {
                    writer.write(symbolIn);
                } else {
                    writer.write(ch);
                }
            }
        }
    }
}
