package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int key = 8;

        crypt(args[0], args[1], args[2], key);
    }

    private static void crypt(String action, String src, String dst, int key) throws IOException {
        if(!action.equals("-e") && !action.equals("-d")) {
            throw new IOException ("Wrong action");
        }

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dst))) {
            int sourceByte;
            int convertedByte = -1;

            while((sourceByte = bis.read()) != -1) {
                if(action.equals("-e")) {
                    convertedByte = sourceByte + key;
                }
                if(action.equals("-d")) {
                    convertedByte = sourceByte - key;
                }
                bos.write(convertedByte);
            }
        }
    }
}
