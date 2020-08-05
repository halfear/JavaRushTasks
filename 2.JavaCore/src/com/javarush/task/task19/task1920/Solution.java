package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> wages;

        wages = fillMap(args[0]);
        ArrayList<String> richest = findRichest(wages);
        print(richest);
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

    private static ArrayList<String> findRichest(TreeMap<String, Double> wages) {
        ArrayList<String> tops = new ArrayList<>();
        String top = "";
        double maxValue = 0;

        for (Map.Entry<String, Double> entry : wages.entrySet()) {
            if(entry.getValue() > maxValue) {
                top = entry.getKey();
                maxValue = entry.getValue();
                tops.add(entry.getKey());
            }
        }
        double finalMaxValue = maxValue;
        String finalTop = top;
        wages.forEach((k, v) -> {
            if(v == finalMaxValue && !k.equals(finalTop)) {
                tops.add(k);
            }
        });
        tops.sort(Comparator.naturalOrder());
        return tops;
    }

    private static void print(ArrayList<String> richest) {
        richest.forEach(System.out::println);
    }
}
