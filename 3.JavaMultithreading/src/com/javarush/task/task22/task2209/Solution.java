package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        String filename = "";
        try(BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = nameReader.readLine();
        }
        StringBuilder builder = new StringBuilder();
        try(BufferedReader textReader = new BufferedReader(new FileReader(filename))) {
            while(textReader.ready()) {
                builder.append(textReader.readLine());
            }
        }
        String[] words = builder.toString().split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> ar = new ArrayList<>(Arrays.asList(words));
        String word = ar.get(0);
        builder.append(word).append(" ");
        String last = word.substring(word.length() - 1);
        ar.remove(0);
        while(!ar.isEmpty()) {
            for(int i = 0; i < ar.size(); i++) {
                word = ar.get(i);
                if(word.substring(0, 1).equalsIgnoreCase(last)) {
                    builder.append(word).append(" ");
                    last = word.substring(word.length() - 1);
                    ar.remove(i);
                }
            }
            System.out.println(ar);
        }
        return builder;
    }
}
