package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            char[] buf = new char[1024];
            int n;
            while ((n = reader.read(buf)) != -1) {
                writer.write(buf, 0, n);
            }
        }
        return writer;
    }
}
