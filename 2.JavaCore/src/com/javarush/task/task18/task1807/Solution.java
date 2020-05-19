package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        File file;
        int currentByte;
        char theByte = ',';

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = new File(reader.readLine());
        }

        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            while(inputStream.available() > 0) {
                currentByte = inputStream.read();
                if(currentByte == theByte) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
