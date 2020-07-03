package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalSystemOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        testString.printSomething();

        System.setOut(originalSystemOut);

        String[] expression = baos.toString().split(" +");

        int result;
        int a = Integer.parseInt(expression[0]);
        int b = Integer.parseInt(expression[2]);

        switch(expression[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + expression[1]);
        }
        System.out.println(baos.toString().trim() + " " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

