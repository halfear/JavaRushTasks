package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> wages;

        wages = fillMap(args[0]);
        printMap(wages);
    }

    private static TreeMap<String, Double> fillMap(String arg) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(arg))) {
            String line = "";
            while(reader.ready()) {
                line = reader.readLine();
                String[] words = line.split(" ");
                String name = words[0];
                String wage = words[1];
                if(map.containsKey(name)) {
                    double value = map.get(name);
                    value += Double.parseDouble(wage);
                    map.put(name, value);
                }
                else {
                    map.put(name, Double.parseDouble(wage));
                }
            }
        }
        return map;
    }

    private static void printMap(TreeMap<String, Double> wages) {
            wages.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
