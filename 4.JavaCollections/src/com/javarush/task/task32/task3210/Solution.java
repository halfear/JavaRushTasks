package com.javarush.task.task32.task3210;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String filename = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try {
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            raf.seek(number);
            byte[] tail = new byte[text.length()];
            raf.read(tail, 0, tail.length);
            raf.seek(raf.length());
            if (new String(tail).equals(text)) {
                raf.write("true".getBytes(StandardCharsets.UTF_8));
            } else raf.write("false".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
