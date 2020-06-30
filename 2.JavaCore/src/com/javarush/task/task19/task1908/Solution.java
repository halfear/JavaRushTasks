package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] fileNames = readFileName();
        String source = fileNames[0];
        String destination = fileNames[1];

        copyNumbers(source, destination);
    }

    private static String[] readFileName() throws IOException {
        String[] names = new String[2];

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            names[0] = reader.readLine();
            names[1] = reader.readLine();
        }
        return names;
    }

    private static void copyNumbers(String source, String destination) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            String symbol;
            String word = "";
            int ch;
            StringBuilder builder = new StringBuilder();

            while((ch = reader.read()) != -1) {
                symbol = String.valueOf((char) ch);
                builder.append((char) ch);
                if(symbol.matches(" ")) {
                    word = builder.substring(0, builder.length() - 1);
                    builder = new StringBuilder();
                    if(word.matches("\\d+")) {
                        writer.append(word).append(" ");
                    }
                }
            }
            word = builder.toString();
            if(word.matches("\\d+")) {
                writer.append(word).append(" ");
            }
        }
    }
}