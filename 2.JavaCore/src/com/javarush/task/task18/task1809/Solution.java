package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File file1;
        File file2;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = new File(reader.readLine());
            file2 = new File(reader.readLine());
        }

        reverseContent(file1, file2);
    }

    private static void reverseContent(File file1, File file2) throws IOException {
        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file2))) {
            byte[] buffer = new byte[inputStream.available()];

            inputStream.read(buffer);
            for(int i = buffer.length - 1; i >= 0; i--) {
                outputStream.write(buffer[i]);
            }
        }
    }
}
