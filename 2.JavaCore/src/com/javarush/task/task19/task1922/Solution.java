package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String filename;

        filename = readFilename();
        filter(filename);
    }

    private static String readFilename() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }

    private static void filter(String filename) throws IOException {
        String line;

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while(reader.ready()) {
                int count = 0;
                line = reader.readLine();
                String[] parts = line.split(" ");
                for(String w : words) {
                    for(String p : parts) {
                        if(w.equals(p)) {
                            count++;
                        }
                    }
                }
                if(count == 2) {
                    System.out.println(line);
                }
            }
        }
    }
}
