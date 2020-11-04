package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset inCS = Charset.forName("Windows-1251");
        Charset outCS = Charset.forName("UTF-8");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), inCS));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), outCS))) {
            char[] buffer = new char[1024];
            int read;
            while((read = br.read(buffer)) != -1) {
                bw.write(buffer, 0, read);
            }
        }
    }
}
