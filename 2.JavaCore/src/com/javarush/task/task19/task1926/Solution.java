package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;

        fileName = readFilename();
        mirrorLines(fileName);
    }

    private static String readFilename() throws IOException {
        String fileName;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        return fileName;
    }

    private static void mirrorLines(String fileName) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()) {
                StringBuilder builder = new StringBuilder();
                String line = reader.readLine();
                for(int i = line.length() - 1; i >= 0; i--) {
                    builder.append(line.charAt(i));
                }
                System.out.println(builder.toString());
            }
        }
    }
}
