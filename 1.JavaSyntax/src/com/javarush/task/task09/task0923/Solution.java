package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution
{
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        String text = getText();
        ArrayList<String> vowelsFromText = new ArrayList<>();
        ArrayList<String> constantsFromText = new ArrayList<>();

        char[] chars = text.toCharArray();
        for (char ch : chars)
        {
            if (isVowel(ch))
            {
                vowelsFromText.add(String.valueOf(ch));
            }
            else
            {
                if (!String.valueOf(ch).equals(" "))
                {
                    constantsFromText.add((String.valueOf(ch)));
                }
            }
        }

        for (String letter : vowelsFromText)
        {
            System.out.print(letter + " ");
        }

        System.out.println();

        for (String letter : constantsFromText)
        {
            System.out.print(letter + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels)
        {  // ищем среди массива гласных
            if (c == d)
            {
                return true;
            }
        }
        return false;
    }

    public static String getText() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine();
        reader.close();
        return result;
    }
}