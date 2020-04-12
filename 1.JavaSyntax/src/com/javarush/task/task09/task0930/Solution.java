package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty())
            {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        // напишите тут ваш код
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String element : array)
        {
            if (isNumber(element.substring(0, 1)))
            {
                numbers.add(Integer.parseInt(element));
            }
            else
            {
                words.add(element);
            }
        }

        numbers.sort(Comparator.reverseOrder());
        words.sort((a, b) ->
                {
                    if (a.equals(b))
                    {
                        return 0;
                    }
                    else
                    {
                        return isGreaterThan(a, b) ? 1 : -1;
                    }
                });

        int numbersIndex = 0;
        int wordsIndex = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                array[i] = String.valueOf(numbers.get(numbersIndex));
                numbersIndex++;
            }
            else
            {
                array[i] = words.get(wordsIndex);
                wordsIndex++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0)
        {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
