package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        try(PrintWriter writer = new PrintWriter(outputStream)) {
            for(Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
                String editedKey = edit(entry.getKey().trim());
                writer.println(editedKey + " = " + entry.getValue());
            }
            writer.flush();
        }
    }

    private static String edit(String key) {
        StringBuilder builder = new StringBuilder();
        String comment = " :=";
        for(char ch : key.toCharArray()) {
            if(comment.contains(Character.toString(ch))) {
                builder.append("\\").append(ch);
            }
            else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            Properties prop = new Properties();
            prop.load(reader);
            Set<String> key = prop.stringPropertyNames();
            key.forEach(k -> runtimeStorage.put(k, prop.getProperty(k)));
        }
    }

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
