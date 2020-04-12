package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> listForSort = new ArrayList<>();
        for (int e : array) listForSort.add(e);
        listForSort.sort(Comparator.naturalOrder());
        for (int i = 0; i < array.length; i++)
        {
            array[i] = listForSort.get(i);
        }
    }
}