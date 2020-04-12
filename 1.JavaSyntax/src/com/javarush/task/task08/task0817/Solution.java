package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution
{
    public static Map<String, String> createMap()
    {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();

        while (map.size() < 10)
        {
            map.put(generateName("Lastname"), generateName("Firstname"));
        }

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map)
    {
        //напишите тут ваш код
        Map<String, String> firstCopy = new HashMap<>(map);
        for (Map.Entry<String, String> entry : firstCopy.entrySet())
        {
            String currentValue = entry.getValue();
            int duplicateCount = 0;
            for (Map.Entry<String, String> pair : firstCopy.entrySet())
            {
                if (pair.getValue().equals(currentValue))
                {
                    duplicateCount++;
                }
            }
            if (duplicateCount > 1) removeItemFromMapByValue(map, entry.getValue());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value)
    {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
            {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args)
    {
        Map<String, String> persons = createMap();
        removeTheFirstNameDuplicates(persons);
    }

    public static String generateName(String prefix)
    {
        int index = (int) (Math.random() * 20);

        return prefix + index;
    }
}
