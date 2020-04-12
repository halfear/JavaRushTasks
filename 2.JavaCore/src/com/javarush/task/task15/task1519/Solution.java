package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напиште тут ваш код
        while(true)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            if(input.equals("exit")) break;

            try
            {
                int parsedInt = (Integer.parseInt(input));
                if(parsedInt > 0 && parsedInt < 128)
                {
                    print(Short.parseShort(input));
                }
                else print(parsedInt);
            }
            catch(NumberFormatException e1)
            {
                try
                {
                    print(Double.parseDouble(input));
                }
                catch(NumberFormatException e2)
                {
                    print(input);
                }
            }
        }

    }

    public static void print(Double value)
    {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value)
    {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value)
    {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value)
    {
        System.out.println("Это тип Integer, значение " + value);
    }
}
