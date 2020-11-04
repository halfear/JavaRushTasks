package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        ArrayList<String> array = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            array.add(token);
        }
        String[] result = new String[array.size()];
        array.toArray(result);
        return result;
    }
}
