package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        File file1 = null;
        File file2 = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = new File(reader.readLine());
            file2 = new File(reader.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<Double> numbersFromFile = getNumbersFromFile(file1);
            ArrayList<Long> roundedLongs = roundDoubles(numbersFromFile);
            writeToFile(file2, roundedLongs);
        }
        catch(IOException e) {
            e.getStackTrace();
        }
    }

    private static ArrayList<Double> getNumbersFromFile(File file1) throws IOException {
        ArrayList<Double> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");
                for(String s : numbers) {
                    result.add(Double.parseDouble(s));
                }
            }
        }

        return result;
    }

    private static ArrayList<Long> roundDoubles(ArrayList<Double> numbersFromFile) {
        return numbersFromFile.stream().map(Math::round).collect(Collectors.toCollection(ArrayList::new));
    }

    private static void writeToFile(File file2, ArrayList<Long> roundedLongs) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
            for(Long l : roundedLongs) {
                writer.write(l.toString() + " ");
            }
        }
    }
}