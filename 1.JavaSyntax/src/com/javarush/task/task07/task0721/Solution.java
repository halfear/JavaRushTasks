package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++)
        {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        maximum = numbers[0];
        minimum = numbers[0];

        for (int i = 1; i < numbers.length; i++)
        {
            int current = numbers[i];
            maximum = current > maximum ? current : maximum;
            minimum = current < minimum ? current : minimum;
        }

        System.out.print(maximum + " " + minimum);
    }
}
