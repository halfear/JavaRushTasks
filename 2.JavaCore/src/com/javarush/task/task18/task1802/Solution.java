package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        File file;
        int minByte;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(reader.readLine());
        }

        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            minByte = inputStream.read();
            while(inputStream.available() > 0) {
                minByte = Math.min(minByte, inputStream.read());
            }
        }

        System.out.println(minByte);
    }
}
