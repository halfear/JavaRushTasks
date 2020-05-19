package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> sortedBytes = new TreeSet<>();
        File file;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(reader.readLine());
        }

        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            while(inputStream.available() > 0) {
                sortedBytes.add(inputStream.read());
            }
        }

        for(Integer i : sortedBytes) {
            System.out.print(i + " ");
        }
    }
}
