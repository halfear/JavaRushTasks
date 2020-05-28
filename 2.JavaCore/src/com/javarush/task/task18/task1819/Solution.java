package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String firstFile = "";
        String secondFile = "";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFile = reader.readLine();
            secondFile = reader.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        try {
            insertContent(firstFile, secondFile);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertContent(String first, String second) throws IOException {

        try(BufferedInputStream fromFirst = new BufferedInputStream(new FileInputStream(first))) {
            ByteArrayOutputStream firstFile = new ByteArrayOutputStream();
            byte[] buf1 = new byte[fromFirst.available()];
            fromFirst.read(buf1);
            firstFile.write(buf1);

            try(BufferedInputStream fromSecond = new BufferedInputStream(new FileInputStream(second));
                BufferedOutputStream toFirst = new BufferedOutputStream(new FileOutputStream(first))) {
                byte[] buf2 = new byte[4096];
                while(fromSecond.available() > 0) {
                    int length = fromSecond.read(buf2);
                    toFirst.write(buf2, 0, length);
                }

                toFirst.write(firstFile.toByteArray());
            }
        }
    }
}
