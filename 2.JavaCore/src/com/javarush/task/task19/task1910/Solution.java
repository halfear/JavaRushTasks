package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    private static final String REGEX = "[^\\wА-я ]";

    public static void main(String[] args) throws IOException {
        String[] fileNames = readFileName();
        String source = fileNames[0];
        String destination = fileNames[1];

        remove(source, destination, REGEX);
    }

    private static String[] readFileName() throws IOException {
        String[] names = new String[2];

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            names[0] = reader.readLine();
            names[1] = reader.readLine();
        }
        return names;
    }

    private static void remove(String source, String destination, String regex) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            int ch;

            while((ch = reader.read()) != -1) {
                if(String.valueOf((char) ch).matches(regex)) {
                } else {
                    writer.write(ch);
                }
            }
        }
    }
}
