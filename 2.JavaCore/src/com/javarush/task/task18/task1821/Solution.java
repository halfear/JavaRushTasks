package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        TreeMap<Integer, Integer> observedSymbols;

        observedSymbols = readFile(fileName);
        printMap(observedSymbols);
    }

    private static TreeMap<Integer, Integer> readFile(String fileName) throws IOException {
        TreeMap<Integer, Integer> result = new TreeMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.US_ASCII))) {
            int symbol;

            while((symbol = reader.read()) != -1) {
                if(!result.containsKey(symbol)) {
                    result.put(symbol, 1);
                }
                else {
                    result.put(symbol, result.get(symbol) + 1);
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            throw new IOException("Reading " + fileName + " exception", e);
        }

        return result;
    }

    private static void printMap(TreeMap<Integer, Integer> observedSymbols) {
        Set<Integer> keySet = observedSymbols.keySet();
        for(Integer i : keySet) {
            System.out.printf("%c %d", (char) i.intValue(), observedSymbols.get(i));
            System.out.println();
        }
    }
}
