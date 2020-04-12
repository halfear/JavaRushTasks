package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = 0;
        String name = "";
        HashMap<String, Integer> wordAndNumber = new HashMap<>();

        while (true)
        {
            try
            {
                id = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException|IOException e)
            {
                break;
            }
            name = reader.readLine();
            if(name.equals(""))
            {
                wordAndNumber.put("", id);
                break;
            }

            wordAndNumber.put(name, id);
        }

        for (Map.Entry<String, Integer> pair : wordAndNumber.entrySet())
        {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
