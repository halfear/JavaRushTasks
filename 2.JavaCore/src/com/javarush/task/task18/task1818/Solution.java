package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        File file1 = new File("");
        File file2 = new File("");
        File file3 = new File("");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = new File(reader.readLine());
            file2 = new File(reader.readLine());
            file3 = new File(reader.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        try {
            mergeFiles(file1, file2, file3);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void mergeFiles(File file1, File file2, File file3) throws IOException {
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file1, true));
            BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(file2));
            BufferedInputStream inputStream3 = new BufferedInputStream(new FileInputStream(file3))) {
            byte[] buffer = new byte[inputStream2.available()];
            outputStream.write(buffer, 0, inputStream2.read(buffer));
            buffer = new byte[inputStream3.available()];
            outputStream.write(buffer, 0, inputStream3.read(buffer));
        }
    }
}
