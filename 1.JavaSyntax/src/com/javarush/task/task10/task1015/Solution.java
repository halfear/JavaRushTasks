package com.javarush.task.task10.task1015;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/* 
Массив списков строк
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList = new ArrayList[0];
        try
        {
            arrayOfStringList = createList();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() throws IOException
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String>[] resultArray = new ArrayList[2];

        ArrayList<String> list1 = new ArrayList<>();
        list1.add(0, "String 1");
        list1.add(0, "String 2");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add(0, "String 3");
        list2.add(0, "String 4");

        resultArray[0] = list1;
        resultArray[1] = list2;

        return resultArray;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list : arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}