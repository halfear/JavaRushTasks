package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int[] a[] = new int[5][5];

        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        String valuableInput = input.substring(input.indexOf('?') + 1);
        String[] param = valuableInput.split("&");

        ArrayList<String> paramList = new ArrayList<>();
        ArrayList<String> valueList = new ArrayList<>();

        for(String s : param)
        {
            String name = "";
            String value = "";
            if(s.contains("="))
            {
                name = s.substring(0, s.indexOf("="));
                value = s.substring(s.indexOf("=") + 1);
                paramList.add(name);
                valueList.add(value);
            }
            else
            {
                paramList.add(s);
                valueList.add("");
            }
        }

        int i;
        for(i = 0; i < paramList.size(); i++)
        {
            System.out.print(paramList.get(i) + " ");
        }
        System.out.println();
        if(paramList.contains("obj"))
        {
            try
            {
                alert(Double.parseDouble(valueList.get(paramList.indexOf("obj"))));
            }
            catch(NumberFormatException e)
            {
                alert(valueList.get(paramList.indexOf("obj")));
            }
        }
    }

    public static void alert(double value)
    {
        System.out.println("double: " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String: " + value);
    }
}
