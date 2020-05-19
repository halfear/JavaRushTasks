package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        File file;
        int maxByte = 0;
        int currentByte;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(reader.readLine());
        }

        try(FileInputStream inputStream = new FileInputStream(file)) {
            while(inputStream.available() > 0) {
                currentByte = inputStream.read();
                maxByte = Math.max(currentByte, maxByte);
            }
        }

        System.out.println(maxByte);
    }
}
