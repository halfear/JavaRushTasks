package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        String filename;

        filename = readFilename();
        print(filename);

    }

    private static String readFilename() throws IOException {
        String filename;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = reader.readLine();
        }

        return filename;
    }

    private static void print(String filename) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while(reader.ready()) {
                String line = reader.readLine();
                String[] words = line.split(" ");
                StringBuilder builder = new StringBuilder();
                for(String word : words) {
                    if (!word.matches("(?<!\\d)\\d(?!\\d)|[1-9][0-2]")) {
                        builder.append(word).append(" ");
                    } else builder.append(map.get(Integer.valueOf(word))).append(" ");
                }
                System.out.println(builder.toString().trim());
            }
        }
    }
}
