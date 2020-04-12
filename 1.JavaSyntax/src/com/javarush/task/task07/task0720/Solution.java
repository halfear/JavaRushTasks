package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++)
        {
            strings.add(reader.readLine());
        }

        for (int moveBack = 0; moveBack < m; moveBack++)
        {
            String firstString = strings.get(0);
            strings.add(firstString);
            strings.remove(0);
        }

        for (String s : strings) System.out.println(s);
    }
}
