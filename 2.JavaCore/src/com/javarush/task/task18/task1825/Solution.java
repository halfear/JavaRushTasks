package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileParts = new ArrayList<>();

        collectParts(fileParts);
        String fileName = getFileName(fileParts);
        fileParts.sort(Comparator.naturalOrder());
        createFullFile(fileName, fileParts);

    }

    private static void collectParts(ArrayList<String> fileParts) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                String string = reader.readLine();
                if(string.equals("end")) {
                    break;
                }
                else {
                    fileParts.add(string);
                }
            }
        }
    }

    private static String getFileName(ArrayList<String> fileParts) {
        String[] nameParts = fileParts.get(0).split("\\.part\\d+");
        return nameParts[0];
    }

    private static void createFullFile(String fileName, ArrayList<String> fileParts) throws IOException {
        for(int i = 0; i < fileParts.size(); i++) {
            try(FileInputStream fis = new FileInputStream(fileParts.get(i));
            FileOutputStream fos = new FileOutputStream(fileName, true)) {
                byte[] buf = new byte[4096];
                int count = 0;

                while((count = fis.read(buf)) != -1) {
                    fos.write(buf, 0, count);
                }
            }
        }
    }
}
