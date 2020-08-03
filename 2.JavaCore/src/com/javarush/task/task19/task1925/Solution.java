package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder builder = new StringBuilder();

            while(reader.ready()) {
                String line = reader.readLine();
                String[] words = line.split(" ");
                Arrays.stream(words).filter(w -> w.length() > 6).forEach(w -> builder.append(w).append(","));
            }
            String editedString = builder.toString();
            writer.write(editedString.substring(0, editedString.length() - 1));
        }
    }
}
