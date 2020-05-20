package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File file1;
        File file2;
        File file3;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = new File(reader.readLine());
            file2 = new File(reader.readLine());
            file3 = new File(reader.readLine());
        }

        splitFile(file1, file2, file3);
    }

    private static void splitFile(File file1, File file2, File file3) throws IOException {
        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream outputStreamFile2 = new BufferedOutputStream(new FileOutputStream(file2));
            BufferedOutputStream outputStreamFile3 = new BufferedOutputStream(new FileOutputStream(file3))) {
            int length = inputStream.available();
            byte[] buffer = length % 2 == 0 ? new byte[length / 2] : new byte[(length / 2) + 1];

            outputStreamFile2.write(buffer, 0 , inputStream.read(buffer));
            outputStreamFile3.write(buffer, 0 , inputStream.read(buffer));
        }
    }
}
