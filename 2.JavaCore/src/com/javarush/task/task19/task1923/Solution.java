package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> words = getWords(args[0]);
        writeWords(args[1], words);
    }

    private static List<String> getWords(String arg) throws IOException {
        List<String> words;
        StringBuilder builder = new StringBuilder();
        String text;

        try (BufferedReader reader = new BufferedReader(new FileReader(arg))) {
            while(reader.ready()) {
                builder.append(reader.readLine());
            }
            text = builder.toString();
        }
        words = Arrays.asList(text.split("\\s"));

        return words;
    }

    private static void writeWords(String arg, List<String> words) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arg))){
            words.stream().filter(s -> s.matches("\\w*\\d+\\w")).forEach(w -> {
                try {
                    writer.write(w);
                    writer.write(" ");
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
