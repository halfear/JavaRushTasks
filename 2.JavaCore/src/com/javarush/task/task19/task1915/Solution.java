package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String fileName = readFileName();

        PrintStream originalSystemOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        testString.printSomething();
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bos.write(baos.toByteArray());
        }

        System.setOut(originalSystemOut);
        System.out.println(baos.toString());
    }

    private static String readFileName() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

