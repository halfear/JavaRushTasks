package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = readFileName();
        String productInfo = getProductInfo(fileName, args[0]);
        System.out.println(productInfo);
    }

    private static String readFileName() throws IOException {
        String fileName;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        return fileName;
    }

    private static String getProductInfo(String fileName, String arg) throws IOException {
        String info = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                if(line.startsWith(arg + " ")) {
                    info = line;
                }
            }
            return info;
        }
    }
}
