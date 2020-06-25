package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        int maxId;

        if(args.length >= 4) {
            if(args[0].equals("-c")) {
                fileName = readFileName();
                maxId = findMaxId(fileName);
                addProduct(fileName, maxId, args);
            }
        }
    }

    private static String readFileName() throws IOException {
        String name;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        }
        return name;
    }

    private static int findMaxId(String fileName) throws IOException {
        int maxId = 0;
        int id;
        String productSignature;

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while((productSignature = reader.readLine()) != null) {
                id = parseId(productSignature);
                maxId = Math.max(maxId, id);
            }
        }
        return maxId;
    }

    private static int parseId(String productSignature) {
        return Integer.parseInt(productSignature.substring(0, 8).trim());
    }

    private static void addProduct(String fileName, int id, String[] args) throws IOException {

        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.printf("%n%-8s%-30s%-8s%-4s", id + 1, args[1], args[2], args[3]);
        }
    }
}