package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String targetWorld = "world";

        String fileName = readFileName();
        int count = wordCounter(fileName, targetWorld);
        System.out.println(count);
    }

    private static String readFileName() throws IOException {
        String name;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        }
        return name;
    }

    private static int wordCounter(String fileName, String targetWord) throws IOException {
        int count = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String symbol;
            String word = "";
            int ch;
            StringBuilder builder = new StringBuilder();

            while((ch = reader.read()) != -1) {
                symbol = String.valueOf((char) ch);
                builder.append((char) ch);
                if(symbol.matches("\\W")) {
                    word = builder.substring(0, builder.length() - 1);
                    builder = new StringBuilder();
                    if(word.equals(targetWord)) {
                        count++;
                    }
                }
            }
            word = builder.toString();
            if(word.equals(targetWord)) {
                count++;
            }
        }
        return count;
    }
}
