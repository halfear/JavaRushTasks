package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* 
Омовение Рамы
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        string = string.replaceAll("\\s+", " ").trim();
        String[] sentence = string.split(" ");
        String result = "";

        for (int i = 0; i < sentence.length; i++)
        {
            String firstLetter = sentence[i].substring(0, 1).toUpperCase();
            sentence[i] = firstLetter + sentence[i].substring(1);
        }

        for (String el : sentence)
        {
            result += el;
            result += " ";
        }
        result.trim();
        System.out.println(result);
    }
}
